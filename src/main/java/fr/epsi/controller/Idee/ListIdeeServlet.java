package fr.epsi.controller.Idee;

import fr.epsi.dto.CommentaireDTO;
import fr.epsi.dto.IdeeDTO;
import fr.epsi.dto.VoteDTO;
import fr.epsi.entite.Idee;
import fr.epsi.service.Commentaire.CommentaireService;
import fr.epsi.service.Idee.IdeeService;
import fr.epsi.service.Vote.VoteService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;


public class ListIdeeServlet extends HttpServlet {
      @EJB
      private IdeeService IdeeService;
      @EJB
      private VoteService VoteService;
      @EJB
      private CommentaireService CommentaireService;

      public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            request.setAttribute("idees", IdeeService.getIdees());
            request.setAttribute("commentaire", CommentaireService.getCommentaires());
            this.getServletContext().getRequestDispatcher("/WEB-INF/idee/Listidees.jsp").forward(request, response);

      }

      protected void doPost(HttpServletRequest req, HttpServletResponse resp)
              throws ServletException, IOException

      {
            Long idIdee = parseLong(req.getParameter("idee_id"));
            Idee idee = IdeeService.getById(idIdee);


            String like = req.getParameter("like");
            String dislike = req.getParameter("dislike");
            Boolean bool = null;
            if (like != null){
                  bool = true;
            }else if(dislike != null){
                  bool = false;
            }

            VoteDTO vDTO=new VoteDTO();
            vDTO.setIdee(idee);
            vDTO.setVote(bool);
            VoteService.create(vDTO);

            System.out.println(req.getParameter("commentaire"));
            CommentaireDTO cDTO = new CommentaireDTO();
            cDTO.setIdee(idee);
            cDTO.setContent(req.getParameter("commentaire"));
            CommentaireService.create(cDTO);


            this.getServletContext().getRequestDispatcher("/WEB-INF/idee/Listidees.jsp").forward(req, resp);
      }
}
