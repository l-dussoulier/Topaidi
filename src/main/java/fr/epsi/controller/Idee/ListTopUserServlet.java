package fr.epsi.controller.Idee;

import fr.epsi.dao.Idee.IdeeDao;
import fr.epsi.dto.CommentaireDTO;
import fr.epsi.dto.IdeeDTO;
import fr.epsi.dto.VoteDTO;
import fr.epsi.entite.Idee;
import fr.epsi.entite.User;
import fr.epsi.service.User.UserService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static java.lang.Long.parseLong;

public class ListTopUserServlet extends HttpServlet {
    @EJB
    private fr.epsi.service.Idee.IdeeService IdeeService;
    @EJB
    private fr.epsi.service.Vote.VoteService VoteService;
    @EJB
    private UserService userService;
    @EJB
    private fr.epsi.service.Commentaire.CommentaireService CommentaireService;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //List<IdeeDTO> i = IdeeService.getTopIdees();
        List<Idee> users = new ArrayList<>();
        /*List<Idee> i = IdeeService.getIdees();
        List<User> users = new ArrayList<>();
        List<Integer> totalIdees = new ArrayList<Integer>();
        boolean incremente = false;

        // On met dans une liste les Users et dans une autre leur nombre d'idées
        for (Idee idee : i){
            if (users.size() == 0){
                users.add(idee.getUser());
                totalIdees.add(1);
            } else {
                for (int x = 0; x < users.size(); x++){
                    if (idee.getUser().equals(users.get(x))){
                        totalIdees.set(x, totalIdees.get(x) + 1);
                        incremente = true;
                        break;
                    }
                } if (incremente == false) {
                    users.add(idee.getUser());
                    totalIdees.add(1);
                }
            }
        }

        // On les classes dans l'ordre décroissant
        for (int x = 0; x < users.size(); x++){

        }

        //userService.getById();
*/
        List<Object[]> l = IdeeService.getTopUsers();
         System.out.println(l.get(0));



        request.setAttribute("topUser", users);
        request.setAttribute("commentaire", CommentaireService.getCommentaires());

        this.getServletContext().getRequestDispatcher("/WEB-INF/idee/topIdees.jsp").forward(request, response);

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
                System.out.println("Vous n'avez pas le droit de voter pour votre idée");
            }
        } else {
            //mettre un message dans le bandeau user à dépassé la  date limite
            System.out.println("Vous avez dépassé la date limite pour voter");
        }

        if (commentaire != null) {
            CommentaireDTO cDTO = new CommentaireDTO();
            cDTO.setIdee(idee);
            cDTO.setContent(req.getParameter("commentaire"));
            cDTO.setUser(user);
            CommentaireService.create(cDTO);
        }
        System.out.println("test");
        resp.sendRedirect("../idee/topVotes");
    }
}
