package fr.epsi.dao;

import fr.epsi.entite.Idee;

import java.util.List;

public interface IdeeDao {
      void create(Idee i);

      List<Idee> getIdees();
}
