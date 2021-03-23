package fr.epsi.dao.Role;

import fr.epsi.dao.User.UserDao;
import fr.epsi.entite.Role;
import fr.epsi.entite.User;

import javax.persistence.EntityManager;
import javax.transaction.*;
import java.util.List;

public class RoleDaoImpl implements RoleDao {

    EntityManager em;
    UserTransaction utx;

    public RoleDaoImpl(EntityManager em, UserTransaction utx) {
        this.em = em;
        this.utx = utx;
    }

    public void create(Role r) {
        try {
            utx.begin();
            em.persist(r);
            utx.commit();
        } catch (NotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SystemException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RollbackException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (HeuristicMixedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (HeuristicRollbackException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    @Override
    public List<Role> getRoles() {
        return em.createQuery("select r from Role r", Role.class).getResultList();
    }

    @Override
    public Role getLastRole() {
        return em.createQuery("select r from Role r ORDER BY r.Niveau", Role.class).getSingleResult();
    }


}
