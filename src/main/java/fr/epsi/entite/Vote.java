package fr.epsi.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vote {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;
      private Boolean vote;
      private User user;

      public Long getId() {
            return id;
      }

      public void setId(Long id) {
            this.id = id;
      }


      public Boolean getVote() {
            return vote;
      }

      public void setVote(Boolean vote) {
            this.vote = vote;
      }

      public User getUser() {
            return user;
      }

      public void setUser(User user) {
            this.user = user;
      }
}
