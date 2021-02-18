package fr.epsi.dto;

import fr.epsi.entite.Categorie;
import fr.epsi.entite.User;

import javax.persistence.*;

public class IdeeDTO {

      private Long id;
      private String titre;
      private String content;
      private fr.epsi.entite.Categorie Categorie;
      private String lienImage;
      private User user;


      public Long getId() {
            return id;
      }

      public void setId(Long id) {
            this.id = id;
      }

      public String getTitre() {
            return titre;
      }

      public void setTitre(String titre) {
            this.titre = titre;
      }

      public fr.epsi.entite.Categorie getCategorie() {
            return Categorie;
      }

      public void setCategorie(fr.epsi.entite.Categorie categorie) {
            Categorie = categorie;
      }

      public String getLienImage() {
            return lienImage;
      }

      public void setLienImage(String lienImage) {
            this.lienImage = lienImage;
      }

      public String getContent() {
            return content;
      }

      public void setContent(String content) {
            this.content = content;
      }

      public User getUser() {
            return user;
      }

      public void setUser(User user) {
            this.user = user;
      }
}