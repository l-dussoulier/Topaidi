package fr.epsi.dto;


public class UserDTO {
    private Long id;
    private String email;
    private String username;
    private String password;
    private fr.epsi.entite.Role role;
    private Boolean isActivate;
    private String nbIdees;

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

    public fr.epsi.entite.Role getRole() {
        return role;
    }

    public void setRole(fr.epsi.entite.Role role) {
        this.role = role;
    }

    public Boolean getActivate() {
        return isActivate;
    }

    public void setActivate(Boolean activate) {
        isActivate = activate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNbIdees() {
        return nbIdees;
    }

    public void setNbIdees(String nbIdees) {
        this.nbIdees = nbIdees;
    }
}
