package fr.epsi.dto;

import fr.epsi.entite.Idee;
import fr.epsi.entite.User;


public class RoleDTO {

      private Long id;
      private String Nom;
      private Integer Niveau;

      public Long getId() {
            return id;
      }

      public void setId(Long id) {
            this.id = id;
      }

      public String getNom() {
            return Nom;
      }

      public void setNom(String nom) {
            Nom = nom;
      }

      public Integer getNiveau() {
            return Niveau;
      }

      public void setNiveau(Integer niveau) {
            Niveau = niveau;
      }
}