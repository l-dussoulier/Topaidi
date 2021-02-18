package fr.epsi.controller;

import fr.epsi.entite.User;
import fr.epsi.service.User.UserService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class LoginServlet extends HttpServlet {

    @EJB
    UserService userService;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {

        System.out.println(req.getParameter("email"));
        System.out.println(req.getParameter("password"));

         List<User> users = userService.getByEmailPassword(req.getParameter("email"),req.getParameter("password"));

         if (users.size() == 0){
             this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
         }
         else{
             User user = users.get(0);


             req.getSession().setAttribute("ID_USER",user.getId());
             req.getSession().setAttribute("EMAIL_USER",user.getEmail());
             req.getSession().setAttribute("ROLEID_USER",user.getRole().getNiveau());
             System.out.println(req.getSession().getAttribute("ROLEID_USER").getClass());
               System.out.println(user.getRole().getNiveau());



             this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(req, resp);
         }

    }



}
