package fr.epsi.service.Idee;

import fr.epsi.dao.Idee.IdeeDao;
import fr.epsi.dao.Idee.IdeeDaoImpl;
import fr.epsi.dto.IdeeDTO;
import fr.epsi.entite.Idee;
import fr.epsi.entite.User;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
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
            i.setImage(ideeDTO.getImage());
            i.setUser(ideeDTO.getUser());
            i.setDateEmission(ideeDTO.getDateEmission());
            IdeeDao dao =new IdeeDaoImpl(em, utx);

            dao.create(i);
      }


      public List<IdeeDTO> getIdees() {
            IdeeDao IdeeDao = new IdeeDaoImpl(em, utx);
            List<IdeeDTO> IdeesListe = new ArrayList<>();

            for (Idee i: IdeeDao.getTopIdees()) {
                  IdeeDTO ideeDTO = new IdeeDTO();
                  ideeDTO.setId(i.getId());
                  ideeDTO.setTitre(i.getTitre());
                  ideeDTO.setContent(i.getContent());
                  ideeDTO.setCategorie(i.getCategorie());
                  ideeDTO.setLienImg(Base64.getEncoder().encodeToString(i.getImage()));
                  ideeDTO.setUser(i.getUser());
                  ideeDTO.setDateEmission(i.getDateEmission());
                  ideeDTO.setFlop(i.getFlop());
                  ideeDTO.setTop(i.getTop());
                  IdeesListe.add(ideeDTO);
            }
            return IdeesListe;
      }

      public List<IdeeDTO> getTopIdees() {
            IdeeDao IdeeDao = new IdeeDaoImpl(em, utx);
            List<IdeeDTO> IdeesListe = new ArrayList<>();

            for (Idee i: IdeeDao.getTopIdees()) {
                  IdeeDTO ideeDTO = new IdeeDTO();
                  ideeDTO.setId(i.getId());
                  ideeDTO.setTitre(i.getTitre());
                  ideeDTO.setContent(i.getContent());
                  ideeDTO.setCategorie(i.getCategorie());
                  ideeDTO.setLienImg(Base64.getEncoder().encodeToString(i.getImage()));
                  ideeDTO.setUser(i.getUser());
                  ideeDTO.setDateEmission(i.getDateEmission());
                  ideeDTO.setTop(i.getTop());
                  ideeDTO.setFlop(i.getFlop());
                  IdeesListe.add(ideeDTO);
            }
            return IdeesListe;
      }

      public List<Object[]> getTopUsers(){
            IdeeDao IdeeDao = new IdeeDaoImpl(em, utx);
            return IdeeDao.getTopUsers();
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

      @Override
      public Long getGoodDate(Long idIdee, Date date) {
            IdeeDao ideeDao = new IdeeDaoImpl(em,utx);
            return ideeDao.getGoodDate(idIdee,date);
      }


}