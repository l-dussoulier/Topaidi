package fr.epsi.dao;

import fr.epsi.entite.Commentaire;
import java.util.List;

public interface CommentaireDao {
    void create(Commentaire com);

    List<Commentaire> getCommentaires();
}
