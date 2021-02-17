package fr.epsi.dao.Vote;

import fr.epsi.entite.Vote;

import javax.persistence.EntityManager;
import javax.transaction.*;
import java.util.List;

public class VoteDaoImpl implements VoteDao {

      EntityManager em;
      UserTransaction utx;

      public VoteDaoImpl(EntityManager em, UserTransaction utx) {
            this.em=em;
            this.utx=utx;
      }
      public void create(Vote v) {
            try {
                  utx.begin();
                  em.persist(v);

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
      public List<Vote> getVotes() {
            return em.createQuery("select i from Vote i", Vote.class).getResultList();
      }


}