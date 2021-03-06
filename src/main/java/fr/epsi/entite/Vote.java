package fr.epsi.entite;

import javax.persistence.*;

@Entity
public class Vote {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;
      private Boolean vote;
      @ManyToOne
      @JoinColumn(name="user_id")
      private User user;
      @ManyToOne
      @JoinColumn(name="idee_id")
      private Idee Idee;

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

      public fr.epsi.entite.Idee getIdee() {
            return Idee;
      }

      public void setIdee(fr.epsi.entite.Idee idee) {
            Idee = idee;
      }
}
