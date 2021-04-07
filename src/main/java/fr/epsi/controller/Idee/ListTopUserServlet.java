package fr.epsi.controller.Idee;

import fr.epsi.dao.Idee.IdeeDao;
import fr.epsi.dto.CommentaireDTO;
import fr.epsi.dto.IdeeDTO;
import fr.epsi.dto.UserDTO;
import fr.epsi.dto.VoteDTO;
import fr.epsi.entite.Idee;
import fr.epsi.entite.User;
import fr.epsi.service.User.UserService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static java.lang.Long.parseLong;

public class ListTopUserServlet extends HttpServlet {
    @EJB
    private fr.epsi.service.Idee.IdeeService IdeeService;
    @EJB
    private fr.epsi.service.Vote.VoteService VoteService;
    @EJB
    private UserService userService;
    @EJB
    private fr.epsi.service.Commentaire.CommentaireService CommentaireService;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

          // récupération d'un array list avec le user et son nombre idée poster
        List<Idee> users = new ArrayList<>();
        User u = new User();
        List<Object[]> l = IdeeService.getTopUsers();
        List<UserDTO> dtoList = new ArrayList<UserDTO>();
         for(Object[] element : l) {
              u = (User) element[0];
              UserDTO userDTO = new UserDTO();
              userDTO.setUsername(u.getUsername());
              userDTO.setNbIdees(element[1].toString());
              userDTO.setEmail(u.getEmail());
              dtoList.add(userDTO);
         }



        request.setAttribute("topUser", dtoList);
        this.getServletContext().getRequestDispatcher("/WEB-INF/idee/topUtilisateurs.jsp").forward(request, response);

    }
}
