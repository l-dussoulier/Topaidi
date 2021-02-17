package fr.epsi.dao.User;

import fr.epsi.entite.User;

import javax.persistence.EntityManager;
import javax.transaction.*;
import java.util.List;

public class UserDaoImpl implements UserDao {

    EntityManager em;
    UserTransaction utx;

    public UserDaoImpl(EntityManager em, UserTransaction utx) {
        this.em = em;
        this.utx = utx;
    }

    public void create(User u) {
        try {
            utx.begin();
            em.persist(u);
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
    public List<User> getUsers() {
        return em.createQuery("select  from User u", User.class).getResultList();
    }
}
