package fr.epsi.dao.User;

import fr.epsi.entite.Role;
import fr.epsi.entite.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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
        return em.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void setRole(User u,Role r,Boolean isActivate) {
        try {
            utx.begin();
            u.setRole(r);
            u.setActivate(isActivate);
            em.merge(u);
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

    public List<User> getByEmailPassword(String email, String password) {
            return em.createQuery("select u from User u where  u.email = :email AND u.password = :password", User.class)
                    .setParameter("email",email)
                    .setParameter("password",password)
                    .getResultList();

    }

    @Override
    public List<User> getByEmail(String email) {
        return em.createQuery("select u from User u where  u.email = :email ", User.class)
                .setParameter("email",email)
                .getResultList();
    }

    @Override
    public void delete(User user)  {
        try{
            utx.begin();
            em.remove(em.merge(user));
            utx.commit();
        }catch (NotSupportedException e) {
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
}

