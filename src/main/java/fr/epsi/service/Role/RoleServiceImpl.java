package fr.epsi.service.Role;

import fr.epsi.dao.Role.RoleDao;
import fr.epsi.dao.Role.RoleDaoImpl;
import fr.epsi.dao.User.UserDao;
import fr.epsi.dao.User.UserDaoImpl;
import fr.epsi.dto.RoleDTO;
import fr.epsi.dto.UserDTO;
import fr.epsi.entite.Role;
import fr.epsi.entite.User;
import fr.epsi.service.User.UserService;

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
public class RoleServiceImpl implements RoleService {

      @PersistenceContext
      EntityManager em;

      @Resource
      UserTransaction utx;


      public void create(RoleDTO roleDTO)  {

            Role r = new Role();
            r.setNiveau(roleDTO.getNiveau());
            r.setNom(roleDTO.getNom());
            RoleDao dao =new RoleDaoImpl(em, utx);

            dao.create(r);
      }


      public List<Role> getRoles() {
            RoleDao roleDao = new RoleDaoImpl(em, utx);
            return roleDao.getRoles();
      }


      public Role getById(Long id) {
            return em.find(Role.class, id);
      }
}