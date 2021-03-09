package fr.epsi.controller.Idee;

import fr.epsi.dto.IdeeDTO;
import fr.epsi.entite.Categorie;
import fr.epsi.entite.User;
import fr.epsi.service.Categorie.CategorieService;
import fr.epsi.service.Idee.IdeeService;
import fr.epsi.service.User.UserService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import static java.lang.Long.parseLong;


public class IdeeServlet extends HttpServlet {

      @EJB
      private CategorieService CategorieService;
      @EJB
      private IdeeService IdeeService;
      @EJB
      private UserService userService;



      protected void doGet(HttpServletRequest req, HttpServletResponse resp)
              throws ServletException, IOException
      {
            req.setAttribute("categories", CategorieService.getCategories());
            System.out.println(CategorieService.getCategories());
            for (Categorie cat : CategorieService.getCategories()) {

                  System.out.println(cat.getId());
                  System.out.println(cat.getNom());
            }

            this.getServletContext().getRequestDispatcher("/WEB-INF/idee/create.jsp").forward(req, resp);
      }

      protected void doPost(HttpServletRequest req, HttpServletResponse resp)
              throws ServletException, IOException

      {

            System.out.println( req.getParameter("email"));
            System.out.println( req.getParameter("categorie-select"));
            System.out.println( req.getParameter("texte"));
            System.out.println( req.getParameter("lien"));


            // récuperer une catégorie par id
            Long idCat = parseLong(req.getParameter("categorie-select"));
            Categorie cat = CategorieService.getById(idCat);
            User user= userService.getById((Long) req.getSession().getAttribute("ID_USER"));
            System.out.println(user);

            IdeeDTO iDTO=new IdeeDTO();
            iDTO.setCategorie(cat);
            iDTO.setUser(user);
            iDTO.setTitre(req.getParameter("titre"));
            iDTO.setContent(req.getParameter("texte"));
            iDTO.setLienImage(req.getParameter("lien"));
            IdeeService.create(iDTO);

            resp.sendRedirect("../idee/listIdees");

      }
}
