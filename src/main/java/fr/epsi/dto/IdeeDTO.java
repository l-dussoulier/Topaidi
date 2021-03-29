package fr.epsi.dto;

import fr.epsi.entite.User;

import java.util.Date;

public class IdeeDTO {

      private Long id;
      private String titre;
      private String content;
      private fr.epsi.entite.Categorie Categorie;
      private byte[] image;
      private User user;
      private Long top;
      private Long flop;
      private Date dateEmission;
      private Long pourcent;
      private String lienImg;



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

      public byte[] getImage() {
            return image;
      }

      public void setImage(byte[] image) {
            this.image = image;
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


      public Long getTop() {
            return top;
      }

      public void setTop(Long top) {
            this.top = top;
      }

      public Long getFlop() {
            return flop;
      }

      public void setFlop(Long flop) {
            this.flop = flop;
      }

      public Date getDateEmission() {
            return dateEmission;
      }

      public void setDateEmission(Date dateEmission) {
            this.dateEmission = dateEmission;
      }

      public Long getPourcent() {
            return pourcent;
      }

      public void setPourcent(Long pourcent) {
            this.pourcent = pourcent;
      }

      public String getLienImg() {
            return lienImg;
      }

      public void setLienImg(String lienImg) {
            this.lienImg = lienImg;
      }
}