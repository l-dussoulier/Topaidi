package fr.epsi.controller;

import fr.epsi.dao.User.UserDao;
import fr.epsi.dto.IdeeDTO;
import fr.epsi.dto.UserDTO;
import fr.epsi.entite.User;
import fr.epsi.service.User.UserService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RegisterServlet extends HttpServlet {

    @EJB
    UserService userService;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        this.getServletContext().getRequestDispatcher("/WEB-INF/auth/register.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {

          UserDTO userDTO = new UserDTO();
          userDTO.setEmail(req.getParameter("email"));
          userDTO.setPassword(req.getParameter("password"));
          userService.create(userDTO);

          req.setAttribute("info", "User créé");
             this.getServletContext().getRequestDispatcher("/WEB-INF/auth/login.jsp").forward(req, resp);
         }

    }




