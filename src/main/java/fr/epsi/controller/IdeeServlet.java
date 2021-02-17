package fr.epsi.controller;

import fr.epsi.dto.IdeeDTO;
import fr.epsi.entite.Categorie;
import fr.epsi.service.CategorieService;
import fr.epsi.service.IdeeService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;


public class IdeeServlet extends HttpServlet {

      @EJB
      private CategorieService CategorieService;
      @EJB
      private IdeeService IdeeService;



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
            System.out.println(cat.getNom());


            IdeeDTO iDTO=new IdeeDTO();
            iDTO.setCategorie(cat);
            iDTO.setTitre(req.getParameter("texte"));
            iDTO.setLienImage(req.getParameter("lien"));
            IdeeService.create(iDTO);

      }
}
