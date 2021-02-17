package fr.epsi.dao.Vote;

import fr.epsi.entite.Vote;

import java.util.List;

public interface VoteDao {
      void create(Vote v);

      List<Vote> getVotes();
}
