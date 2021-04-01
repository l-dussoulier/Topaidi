package fr.epsi.service.Idee;

import fr.epsi.dto.IdeeDTO;
import fr.epsi.entite.Idee;
import fr.epsi.entite.User;

import java.util.Date;
import java.util.List;

public interface IdeeService {

      void create(IdeeDTO i);

      List<IdeeDTO> getIdees();

      List<IdeeDTO> getTopIdees();

      List<Object[]> getTopUsers();

      Idee getById(Long id);

      void setLike(Idee i,Long top);

      void setDisLike(Idee i,Long flop);

      long getHisIdea(Long idUser, Long idIdee);

      Long getGoodDate(Long idIdee, Date date);
}
