package fr.epsi.service;

import fr.epsi.dto.CommentaireDTO;
import fr.epsi.entite.Commentaire;

import java.util.List;

public interface CommentaireService {
    void create(CommentaireDTO com);
    List<Commentaire> getCommentaires();
}
