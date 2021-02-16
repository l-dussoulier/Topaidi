package fr.epsi.service;

import fr.epsi.dto.IdeeDTO;
import fr.epsi.entite.Idee;

import java.util.List;

public interface IdeeService {

      void create(IdeeDTO i);

      List<Idee> getIdees();

}
