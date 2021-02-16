package fr.epsi.controller;

import fr.epsi.entite.Idee;
import fr.epsi.service.IdeeService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IdeeServlet extends HttpServlet {

      //private IdeeService IdeeService;

      protected void doGet(HttpServletRequest req, HttpServletResponse resp)
              throws ServletException, IOException
      {
            //req.setAttribute("categorie", IdeeService.getIdees());

            this.getServletContext().getRequestDispatcher("/WEB-INF/idee/create.jsp").forward(req, resp);
      }
}
