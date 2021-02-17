package fr.epsi.controller;

import fr.epsi.entite.Categorie;
import fr.epsi.entite.Idee;
import fr.epsi.service.CategorieService;
import fr.epsi.service.IdeeService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class IdeeServlet extends HttpServlet {

      @EJB
      private CategorieService CategorieService;

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

      }
}
