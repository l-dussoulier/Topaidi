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
            u.setUsername(userDTO.getUsername());
            u.setPassword(userDTO.getPassword());
            u.setActivate(Boolean.FALSE);
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


      public void setRole(User u, Role r,Boolean isActivate) {
            UserDao UserDao = new UserDaoImpl(em, utx);
            UserDao.setRole(u,r,isActivate);
      }

      public List<User> getByEmailPassword(String email, String password) {
            UserDao UserDao = new UserDaoImpl(em, utx);
            return UserDao.getByEmailPassword(email,password);
      }


      public List<User> getByEmail(String email) {
            UserDao UserDao = new UserDaoImpl(em, utx);
            return UserDao.getByEmail(email);
      }

      @Override
      public void delete(User user) {
            UserDao userDao = new UserDaoImpl(em,utx);
            userDao.delete(user);
      }


}