package fr.epsi.entite;

import javax.persistence.*;


@Entity
public class Idee {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;
      private String titre;
      @ManyToOne
      @JoinColumn(name="categorie_id")
      private Categorie Categorie;
      private String lienImage;


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
}