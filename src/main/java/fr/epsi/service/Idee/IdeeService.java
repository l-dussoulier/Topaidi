package fr.epsi.service.Idee;

import fr.epsi.dto.IdeeDTO;
import fr.epsi.entite.Categorie;
import fr.epsi.entite.Idee;

import java.util.List;

public interface IdeeService {

      void create(IdeeDTO i);

      List<Idee> getIdees();

      Idee getById(Long id);

}
