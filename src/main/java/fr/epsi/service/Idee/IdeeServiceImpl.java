package fr.epsi.service.Idee;

import fr.epsi.dao.Idee.IdeeDao;
import fr.epsi.dao.Idee.IdeeDaoImpl;
import fr.epsi.dao.User.UserDao;
import fr.epsi.dao.User.UserDaoImpl;
import fr.epsi.dao.Vote.VoteDao;
import fr.epsi.dao.Vote.VoteDaoImpl;
import fr.epsi.dto.IdeeDTO;
import fr.epsi.entite.Categorie;
import fr.epsi.entite.Idee;

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
public class IdeeServiceImpl implements IdeeService {

      @PersistenceContext
      EntityManager em;

      @Resource
      UserTransaction utx;


      public void create(IdeeDTO ideeDTO)  {

            Idee i = new Idee();
            i.setTitre(ideeDTO.getTitre());
            i.setContent(ideeDTO.getContent());
            i.setCategorie(ideeDTO.getCategorie());
            i.setLienImage(ideeDTO.getLienImage());
            i.setUser(ideeDTO.getUser());
            i.setDateEmission(ideeDTO.getDateEmission());
            IdeeDao dao =new IdeeDaoImpl(em, utx);

            dao.create(i);
      }


      public List<Idee> getIdees() {
            IdeeDao IdeeDao = new IdeeDaoImpl(em, utx);
            return IdeeDao.getIdees();
      }

      @Override
      public Idee getById(Long id) {
            return em.find(Idee.class, id);
      }

      @Override
      public void  setLike(Idee i,Long top) {
            IdeeDao ideeDao = new IdeeDaoImpl(em, utx);
            ideeDao.setLike(i,top);
      }

      @Override
      public void setDisLike(Idee i, Long flop) {
            IdeeDao ideeDao = new IdeeDaoImpl(em, utx);
            ideeDao.setDisLike(i,flop);
      }

      @Override
      public long getHisIdea(Long idUser, Long idIdee) {
            IdeeDao ideeDao = new IdeeDaoImpl(em,utx);
            return ideeDao.getHisIdea(idUser,idIdee);
      }


}