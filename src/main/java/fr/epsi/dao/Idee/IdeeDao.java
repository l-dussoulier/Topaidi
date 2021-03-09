package fr.epsi.dao.Idee;

import fr.epsi.entite.Idee;

import java.util.Date;
import java.util.List;

public interface IdeeDao {
      void create(Idee i);

      List<Idee> getIdees();

      void setLike(Idee i, Long top);

      void setDisLike(Idee i, Long flop);

      long getHisIdea(Long idUser, Long idIdee);

      Long getGoodDate(Long idIdee, Date date);
}
