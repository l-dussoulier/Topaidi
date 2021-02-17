package fr.epsi.controller.Idee;

import fr.epsi.dto.IdeeDTO;
import fr.epsi.dto.VoteDTO;
import fr.epsi.entite.Idee;
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

      public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            request.setAttribute("idees", IdeeService.getIdees());
            this.getServletContext().getRequestDispatcher("/WEB-INF/idee/Listidees.jsp").forward(request, response);

      }

      protected void doPost(HttpServletRequest req, HttpServletResponse resp)
              throws ServletException, IOException

      {


            String like = req.getParameter("like");
            String dislike = req.getParameter("dislike");

            Boolean bool = null;
            if (like != null){
                  bool = true;
            }else if(dislike != null){
                  bool = false;
            }


            Long idIdee = parseLong(req.getParameter("idee_id"));
            Idee idee = IdeeService.getById(idIdee);
            VoteDTO vDTO=new VoteDTO();
            vDTO.setIdee(idee);
            vDTO.setVote(bool);
            VoteService.create(vDTO);


            this.getServletContext().getRequestDispatcher("/WEB-INF/idee/Listidees.jsp").forward(req, resp);
      }
}
