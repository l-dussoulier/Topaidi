package fr.epsi.dto;

import fr.epsi.entite.Idee;
import fr.epsi.entite.User;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class CommentaireDTO {
    private Long id;
    private String content;
    private fr.epsi.entite.User user;
    private fr.epsi.entite.Idee idee;

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

    public fr.epsi.entite.User getUser() {
        return user;
    }

    public void setUser(fr.epsi.entite.User user) {
        this.user = user;
    }

    public fr.epsi.entite.Idee getIdee() {
        return idee;
    }

    public void setIdee(fr.epsi.entite.Idee idee) {
        this.idee = idee;
    }
}
