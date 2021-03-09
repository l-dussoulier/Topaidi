package fr.epsi.dao.Vote;

import fr.epsi.entite.Idee;
import fr.epsi.entite.Vote;

import java.util.List;

public interface VoteDao {
      void create(Vote v);

      List<Vote> getVotes();

      Long countVote(Idee idee_id);

      Long getVotesIdeeUser(Long idUser,Long idIdee);
}
