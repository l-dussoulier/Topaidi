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
      import java.math.BigInteger;
      import java.security.MessageDigest;
      import java.security.NoSuchAlgorithmException;
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
                if (userService.getByEmail(req.getParameter("email")).size() > 0){
                      req.setAttribute("info", "Email déjà utilisé");
                      this.getServletContext().getRequestDispatcher("/WEB-INF/auth/login.jsp").forward(req, resp);
                }else
                      {
                      UserDTO userDTO = new UserDTO();
                      userDTO.setEmail(req.getParameter("email"));
                      // MH5
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
                      // Fin
                      userDTO.setUsername(req.getParameter("username"));
                      userDTO.setPassword(hashtext);
                      userService.create(userDTO);

                      req.setAttribute("info", "User créé");
                      this.getServletContext().getRequestDispatcher("/WEB-INF/auth/login.jsp").forward(req, resp);
                      }
               }

          }




