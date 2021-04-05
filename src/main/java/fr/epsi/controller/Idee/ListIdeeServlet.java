package fr.epsi.controller.Idee;

import fr.epsi.controller.HomeServlet;
import fr.epsi.dto.CommentaireDTO;
import fr.epsi.dto.IdeeDTO;
import fr.epsi.dto.VoteDTO;
import fr.epsi.entite.Idee;
import fr.epsi.entite.User;
import fr.epsi.service.Commentaire.CommentaireService;
import fr.epsi.service.Idee.IdeeService;
import fr.epsi.service.User.UserService;
import fr.epsi.service.Vote.VoteService;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;

import static java.lang.Long.parseLong;


public class ListIdeeServlet extends HttpServlet {
      @EJB
      private IdeeService IdeeService;
      @EJB
      private VoteService VoteService;
      @EJB
      private UserService userService;
      @EJB
      private CommentaireService CommentaireService;

      public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

            request.setAttribute("idees", IdeeService.getIdees());
            System.out.println(IdeeService.getTopIdees().get(0).getFlop());
            request.setAttribute("commentaire", CommentaireService.getCommentaires());

            this.getServletContext().getRequestDispatcher("/WEB-INF/idee/Listidees.jsp").forward(request, response);

      }

      protected void doPost(HttpServletRequest req, HttpServletResponse resp)
              throws ServletException, IOException
      {

            String like = req.getParameter("like");
            String dislike = req.getParameter("dislike");
            String commentaire = req.getParameter("commentaire");

            // recuperation du user
            Long idUser = (Long) req.getSession().getAttribute("ID_USER");
            User user =  userService.getById(idUser);

            // recuperation du idée
            System.out.println(req.getParameter("idee_id"));
            Long idIdee = parseLong(req.getParameter("idee_id"));
            Idee idee = IdeeService.getById(idIdee);
            VoteDTO vDTO=new VoteDTO();
            vDTO.setIdee(idee);
            vDTO.setUser(user);

            Date date = new Date();
            if(IdeeService.getGoodDate(idIdee,date) == 0 ){
                  if (IdeeService.getHisIdea(idUser,idIdee) == 0) {
                        if (VoteService.getVotesIdeeUser(idUser, idIdee) == 0) {
                              Boolean bool = null;
                              if (like != null) {
                                    bool = true;
                                    Long nblike = idee.getTop();
                                    nblike = nblike + 1;
                                    IdeeService.setLike(idee, nblike);
                              } else if (dislike != null) {
                                    bool = false;
                                    Long nbdislike = idee.getFlop();
                                    nbdislike = nbdislike + 1;
                                    IdeeService.setDisLike(idee, nbdislike);
                              }
                              vDTO.setVote(bool);
                              VoteService.create(vDTO);
                        }else{
                              //mettre un message dans le bandeau déjà voté pour cette idée
                              System.out.println("Vous avez déjà voté pour cette idée");
                        }
                  }else {
                        //mettre un message dans le bandeau user pas le droit de voté pour son idée
                        System.out.println("Vous n'avez pas le droit de voté pour votre idée");
                        req.setAttribute("infoIdees", "Vous n'avez pas le droit de voté pour votre idée");

                  }
            } else {
                  //mettre un message dans le bandeau user à dépassé la  date limite
                  System.out.println("Vous n'avez dépassé la date limite pour voté");
            }

            if (commentaire != null) {
                  CommentaireDTO cDTO = new CommentaireDTO();
                  cDTO.setIdee(idee);
                  cDTO.setContent(req.getParameter("commentaire"));
                  cDTO.setUser(user);
                  CommentaireService.create(cDTO);
            }

            resp.sendRedirect("../idee/listIdees");
      }
}
