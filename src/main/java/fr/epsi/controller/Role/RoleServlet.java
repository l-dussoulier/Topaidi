package fr.epsi.controller.Role;

import fr.epsi.dto.CategorieDTO;
import fr.epsi.dto.RoleDTO;
import fr.epsi.dto.UserDTO;
import fr.epsi.service.Categorie.CategorieService;
import fr.epsi.service.Role.RoleService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class RoleServlet extends HttpServlet {

      @EJB
      private RoleService roleService;

      protected void doGet(HttpServletRequest req, HttpServletResponse resp)
              throws ServletException, IOException
      {
            this.getServletContext().getRequestDispatcher("/WEB-INF/role/createRole.jsp").forward(req, resp);
      }

      protected void doPost(HttpServletRequest req, HttpServletResponse resp)
              throws ServletException, IOException
      {
            // création d'un rôle
            RoleDTO rDTO =new RoleDTO();
            rDTO.setNom(req.getParameter("role"));
            rDTO.setNiveau(roleService.getRoles().size()+1);
            roleService.create(rDTO);

            req.setAttribute("info", "Un nouveau rôle a été créer");
            this.getServletContext().getRequestDispatcher("/WEB-INF/idee/Listidees.jsp").forward(req, resp);
      }
}
