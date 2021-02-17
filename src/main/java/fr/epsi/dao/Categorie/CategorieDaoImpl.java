package fr.epsi.dao.Categorie;

import fr.epsi.entite.Categorie;

import javax.persistence.EntityManager;
import javax.transaction.*;
import java.util.List;

public class CategorieDaoImpl implements CategorieDao {
    EntityManager em;
    UserTransaction utx;

    public CategorieDaoImpl(EntityManager em, UserTransaction utx){
        this.em = em;
        this.utx = utx;
    }

    public void create(Categorie c){
        try{
            utx.begin();
            em.persist(c);
            utx.commit();
        } catch (NotSupportedException e) {
            e.printStackTrace();
        } catch (SystemException e) {
            e.printStackTrace();
        } catch (HeuristicMixedException e) {
            e.printStackTrace();
        } catch (HeuristicRollbackException e) {
            e.printStackTrace();
        } catch (RollbackException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Categorie getById(int idcat) {
        return em.createQuery("select c from Categorie c WHERE c.id = :id ",Categorie.class)
                .setParameter("id", idcat)
                .getSingleResult();
    }

    @Override
    public List<Categorie> getCategories() {
        return em.createQuery("select c from Categorie c", Categorie.class).getResultList();
    }
}
