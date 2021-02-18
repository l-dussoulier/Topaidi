package fr.epsi.service.User;

import fr.epsi.dao.Idee.IdeeDao;
import fr.epsi.dao.Idee.IdeeDaoImpl;
import fr.epsi.dao.User.UserDao;
import fr.epsi.dao.User.UserDaoImpl;
import fr.epsi.dto.IdeeDTO;
import fr.epsi.dto.UserDTO;
import fr.epsi.entite.Idee;
import fr.epsi.entite.Role;
import fr.epsi.entite.User;
import fr.epsi.service.Idee.IdeeService;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class UserServiceImpl implements UserService {

      @PersistenceContext
      EntityManager em;

      @Resource
      UserTransaction utx;


      public void create(UserDTO userDTO)  {

            User u = new User();
            u.setEmail(userDTO.getEmail());
            u.setPassword(userDTO.getPassword());
            UserDao dao =new UserDaoImpl(em, utx);

            dao.create(u);
      }


      public List<User> getUsers() {
            UserDao UserDao = new UserDaoImpl(em, utx);
            return UserDao.getUsers();
      }


      public User getById(Long id) {
            return em.find(User.class, id);
      }


      public void setRole(User u, Role r) {
            UserDao UserDao = new UserDaoImpl(em, utx);
            UserDao.setRole(u,r);
      }

      public List<User> getByEmailPassword(String email, String password) {
            UserDao UserDao = new UserDaoImpl(em, utx);
            return UserDao.getByEmailPassword(email,password);
      }



}