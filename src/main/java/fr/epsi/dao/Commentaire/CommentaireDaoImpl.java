package fr.epsi.dao.Commentaire;

import fr.epsi.entite.Commentaire;

import javax.persistence.EntityManager;
import javax.transaction.*;
import java.util.List;

public class CommentaireDaoImpl implements CommentaireDao {

    EntityManager em;
    UserTransaction utx;

    public CommentaireDaoImpl(EntityManager em, UserTransaction utx) {
        this.em = em;
        this.utx = utx;
    }

    public void create(Commentaire com) {
        try {
            utx.begin();
            em.persist(com);
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
    public List<Commentaire> getCommentaires() {
        return em.createQuery("select com from Commentaire com", Commentaire.class).getResultList();
    }
}