package fr.epsi.controller.User;

import fr.epsi.dto.UserDTO;
import fr.epsi.service.User.UserService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;




public class UserServlet extends HttpServlet {

    @EJB
    private UserService UserService;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        this.getServletContext().getRequestDispatcher("/WEB-INF/user/create.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException

    {
        UserDTO uDTO =new UserDTO();
        uDTO.setEmail(req.getParameter("email"));
        uDTO.setPassword(req.getParameter("password"));
        UserService.create(uDTO);

        this.getServletContext().getRequestDispatcher("/WEB-INF/idee/Listidees.jsp").forward(req, resp);

    }
}
