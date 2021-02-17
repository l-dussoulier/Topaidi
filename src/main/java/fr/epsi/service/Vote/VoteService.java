package fr.epsi.service.Vote;

import fr.epsi.dto.VoteDTO;
import fr.epsi.entite.Vote;

import java.util.List;

public interface VoteService {
    void create(VoteDTO v);
    List<Vote> getVotes();
}
