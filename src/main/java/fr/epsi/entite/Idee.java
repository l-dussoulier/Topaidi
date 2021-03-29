package fr.epsi.entite;

import javax.persistence.*;

import java.util.Date;

import static java.lang.Long.parseLong;


@Entity
public class Idee {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;
      private String titre;
      private String content;
      @ManyToOne
      @JoinColumn(name="categorie_id")
      private Categorie Categorie;
      @Lob
      private byte[] image;
      @ManyToOne
      @JoinColumn(name="user_id")
      private User user;
      private Long top = parseLong("0");
      private Long flop = parseLong("0");
      private Date dateEmission;

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

      public User getUser() {
            return user;
      }

      public void setUser(User user) {
            this.user = user;
      }

      public String getContent() {
            return content;
      }

      public void setContent(String content) {
            this.content = content;
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
}