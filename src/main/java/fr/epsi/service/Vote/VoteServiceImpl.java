package fr.epsi.service.Vote;

import fr.epsi.dao.Vote.VoteDao;
import fr.epsi.dao.Vote.VoteDaoImpl;
import fr.epsi.dto.VoteDTO;
import fr.epsi.entite.Idee;
import fr.epsi.entite.Vote;

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
public class VoteServiceImpl implements VoteService {

      @PersistenceContext
      EntityManager em;

      @Resource
      UserTransaction utx;


      public void create(VoteDTO VoteDTO)  {

            Vote v = new Vote();
            v.setIdee(VoteDTO.getIdee());
            v.setVote(VoteDTO.getVote());
            v.setUser(VoteDTO.getUser());
            VoteDao dao =new VoteDaoImpl(em, utx);

            dao.create(v);
      }


      public List<Vote> getVotes() {
            VoteDao VoteDao = new VoteDaoImpl(em, utx);
            return VoteDao.getVotes();
      }

      @Override
      public Long countVote(Idee idee_id) {
            VoteDao voteDao = new VoteDaoImpl(em,utx);
            return voteDao.countVote(idee_id);
      }

      public Long getVotesIdeeUser(Long idUser, Long idIdee){

            VoteDao voteDao = new VoteDaoImpl(em,utx);
            return voteDao.getVotesIdeeUser(idUser,idIdee);
      }
}