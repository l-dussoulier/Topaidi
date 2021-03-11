package fr.epsi.entite;

import javax.persistence.*;

@Entity
public class User {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;
      private String email;
      private String password;
      @ManyToOne
      @JoinColumn(name="role_id")
      private Role role;

      private Boolean isActivate;

      public Long getId() {
            return id;
      }

      public void setId(Long id) {
            this.id = id;
      }


      public String getEmail() {
            return email;
      }

      public void setEmail(String email) {
            this.email = email;
      }

      public String getPassword() {
            return password;
      }

      public void setPassword(String password) {
            this.password = password;
      }

      public Role getRole() {
            return role;
      }

      public void setRole(Role role) {
            this.role = role;
      }

      public Boolean getActivate() {
            return isActivate;
      }

      public void setActivate(Boolean activate) {
            isActivate = activate;
      }
}
