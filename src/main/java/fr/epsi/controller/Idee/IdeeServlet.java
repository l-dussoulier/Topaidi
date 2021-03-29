package fr.epsi.controller.Idee;

import fr.epsi.dto.IdeeDTO;
import fr.epsi.entite.Categorie;
import fr.epsi.entite.User;
import fr.epsi.service.Categorie.CategorieService;
import fr.epsi.service.Idee.IdeeService;
import fr.epsi.service.User.UserService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Date;

import static java.lang.Long.parseLong;

@MultipartConfig
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

            this.getServletContext().getRequestDispatcher("/WEB-INF/idee/create.jsp").forward(req, resp);
      }

      protected void doPost(HttpServletRequest req, HttpServletResponse resp)
              throws ServletException, IOException

      {

            //
            Part filePart = req.getPart("imgtest"); // Retrieves <input type="file" name="file">
            InputStream fileContent = filePart.getInputStream();
            byte[] image = fileContent.readAllBytes();



            // récuperer une catégorie par id
            Long idCat = parseLong(req.getParameter("categorie-select"));
            Categorie cat = CategorieService.getById(idCat);
            User user= userService.getById((Long) req.getSession().getAttribute("ID_USER"));

            IdeeDTO iDTO=new IdeeDTO();
            iDTO.setCategorie(cat);
            iDTO.setUser(user);
            iDTO.setTitre(req.getParameter("titre"));
            iDTO.setContent(req.getParameter("texte"));
            iDTO.setImage(image);
            Date date = new Date();
            iDTO.setDateEmission(date);
            IdeeService.create(iDTO);

            resp.sendRedirect("../idee/listIdees");

      }
}
