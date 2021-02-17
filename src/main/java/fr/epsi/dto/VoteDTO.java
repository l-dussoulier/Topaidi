package fr.epsi.dto;

import fr.epsi.entite.Idee;
import fr.epsi.entite.User;


public class VoteDTO {

      private Long id;
      private Boolean vote;
      private User user;
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