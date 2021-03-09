package fr.epsi.controller;

import fr.epsi.dto.CategorieDTO;
import fr.epsi.dto.IdeeDTO;
import fr.epsi.dto.VoteDTO;
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
import static java.lang.Long.parseLong;


public class CategorieServlet extends HttpServlet {

    @EJB
    private CategorieService CategorieService;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        this.getServletContext().getRequestDispatcher("/WEB-INF/createCat.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {

        String categorie = req.getParameter("categorie");
        CategorieDTO cDTO = new CategorieDTO();
        cDTO.setNom(categorie);
        CategorieService.create(cDTO);

        this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(req, resp);
    }
}
