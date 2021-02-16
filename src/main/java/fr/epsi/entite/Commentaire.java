package fr.epsi.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Commentaire {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;
      private String content;
      private User user;
      private Idee idee;

      public Long getId() {
            return id;
      }

      public void setId(Long id) {
            this.id = id;
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

      public Idee getIdee() {
            return idee;
      }

      public void setIdee(Idee idee) {
            this.idee = idee;
      }
}
