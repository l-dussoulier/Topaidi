package fr.epsi.controller;

import fr.epsi.entite.User;
import fr.epsi.service.User.UserService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class LoginServlet extends HttpServlet {

    @EJB
    UserService userService;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        this.getServletContext().getRequestDispatcher("/WEB-INF/auth/login.jsp").forward(req, resp);
    }



    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
          // fonction de hash MD5
          String plaintext = req.getParameter("password");
          MessageDigest m = null;
          try {
                m = MessageDigest.getInstance("MD5");
          } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
          }
          m.reset();
          m.update(plaintext.getBytes());
          byte[] digest = m.digest();
          BigInteger bigInt = new BigInteger(1,digest);
          String hashtext = bigInt.toString(16);
          //

          List<User> users = userService.getByEmailPassword(req.getParameter("email"),hashtext);

               if (users.size() == 0) {
                     req.setAttribute("info","Erreur dans l'email ou le mot de passe");
                     this.getServletContext().getRequestDispatcher("/WEB-INF/auth/login.jsp").forward(req, resp);

               }
               if(users.get(0).getRole() == null){
                     req.setAttribute("info","L'utilisateur doit avoir un rôle pour se connecter");
                     this.getServletContext().getRequestDispatcher("/WEB-INF/auth/login.jsp").forward(req, resp);
               }
               else {
                     if (users.get(0).getActivate() == false){
                           req.setAttribute("info","Utilisateur "+users.get(0).getEmail() +" est bloqué");
                           this.getServletContext().getRequestDispatcher("/WEB-INF/auth/login.jsp").forward(req, resp);

                     }
                     else{
                           // mise en session
                           User user = users.get(0);
                           req.getSession().setAttribute("ID_USER",user.getId());
                           req.getSession().setAttribute("USERNAME",user.getUsername());
                           req.getSession().setAttribute("EMAIL_USER",user.getEmail());
                           req.getSession().setAttribute("ROLEID_USER",user.getRole().getNiveau());

                           //this.getServletContext().getRequestDispatcher("/WEB-INF/idee/Listidees.jsp").forward(req, resp);
                           resp.sendRedirect("../Topaidi-1.0-SNAPSHOT/idee/listIdees");
                     }

               }


    }



}
