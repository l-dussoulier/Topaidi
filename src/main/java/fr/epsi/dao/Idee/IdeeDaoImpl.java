package fr.epsi.dao.Idee;

import fr.epsi.entite.Idee;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.*;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
            return em.createQuery("select i from Idee i ORDER BY i.id DESC", Idee.class).getResultList();
      }

      @Override
      public List<Idee> getTopIdees() {
            return em.createQuery("select i from Idee i ORDER BY i.dateEmission ASC", Idee.class).getResultList();
      }

      @Override
      public void setLike(Idee i, Long top) {
            try {

                  utx.begin();
                  i.setTop(top);
                  em.merge(i);
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
      public void setDisLike(Idee i, Long flop) {
            try {

                  utx.begin();
                  i.setFlop(flop);
                  em.merge(i);
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
      public long getHisIdea(Long idUser, Long idIdee) {
            return em.createQuery("select COUNT(i) from Idee i where i.id = :idIdee AND i.user.id = :idUser",Long.class)
                    .setParameter("idIdee",idIdee)
                    .setParameter("idUser",idUser)
                    .getSingleResult();
      }

      @Override
      public Long getGoodDate(Long idIdee, Date date) {
            date.setTime(date.getTime() + TimeUnit.DAYS.toMillis(-7));
            return em.createQuery("select COUNT(i) from Idee i where i.id = :idIdee AND i.dateEmission <= :dateEmi",Long.class)
                    .setParameter("idIdee",idIdee)
                    .setParameter("dateEmi",date)
                    .getSingleResult();
      }


}