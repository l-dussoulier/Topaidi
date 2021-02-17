package fr.epsi.dao.Idee;

import fr.epsi.entite.Idee;

import javax.persistence.EntityManager;
import javax.transaction.*;
import java.util.List;

public class IdeeDaoImpl implements IdeeDao {

      EntityManager em;
      UserTransaction utx;

      public IdeeDaoImpl(EntityManager em, UserTransaction utx) {
            this.em=em;
            this.utx=utx;
      }
      public void create(Idee i) {
            try {
                  utx.begin();
                  em.persist(i);

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
      public List<Idee> getIdees() {
            return em.createQuery("select i from Idee i", Idee.class).getResultList();
      }
}