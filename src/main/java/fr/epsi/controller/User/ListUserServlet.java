package fr.epsi.controller.User;

import fr.epsi.dto.VoteDTO;
import fr.epsi.entite.Idee;
import fr.epsi.entite.Role;
import fr.epsi.entite.User;
import fr.epsi.service.Idee.IdeeService;
import fr.epsi.service.Role.RoleService;
import fr.epsi.service.User.UserService;
import fr.epsi.service.Vote.VoteService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Long.parseLong;


public class ListUserServlet extends HttpServlet {
      @EJB
      private UserService UserService;
      @EJB
      private RoleService roleService;


      public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

            request.setAttribute("users", UserService.getUsers());
            request.setAttribute("roles", roleService.getRoles());

            this.getServletContext().getRequestDispatcher("/WEB-INF/user/ListUsers.jsp").forward(request, response);

      }

      protected void doPost(HttpServletRequest req, HttpServletResponse resp)
              throws ServletException, IOException

      {
            Long idRole = parseLong(req.getParameter("role-select"));
            Role role =  roleService.getById(idRole);
            Long idUser = parseLong(req.getParameter("idUser"));
            String isActivate = req.getParameter("isActivate");
            User user =  UserService.getById(idUser);

            if (isActivate == null){
                  isActivate = "FAlse";
            }
            else {
                 isActivate = "TRue";
            }
            boolean bool =Boolean.parseBoolean(isActivate);

            UserService.setRole(user,role,bool);
            req.getSession().setAttribute("ROLEID_USER",user.getRole().getNiveau());
            req.setAttribute("info","modification de l'utilisateur " +user.getEmail()+" Réussite");

            String delete = req.getParameter("delete");
            if (delete != null){
                  UserService.delete(user);
                  resp.sendRedirect("../user/listUsers");
            }


            this.getServletContext().getRequestDispatcher("/WEB-INF/idee/Listidees.jsp").forward(req, resp);
      }
}
