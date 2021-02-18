package fr.epsi.service.Commentaire;

import fr.epsi.dao.Commentaire.CommentaireDao;
import fr.epsi.dao.Commentaire.CommentaireDaoImpl;
import fr.epsi.dto.CommentaireDTO;
import fr.epsi.entite.Commentaire;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class CommentaireServiceImpl implements CommentaireService {

    @PersistenceContext
    EntityManager em;

    @Resource
    UserTransaction utx;

    public void create(CommentaireDTO commentaireDTO){
        Commentaire c = new Commentaire();
        c.setIdee(commentaireDTO.getIdee());
        c.setUser(commentaireDTO.getUser());
        c.setContent(commentaireDTO.getContent());
        CommentaireDao dao = new CommentaireDaoImpl(em, utx);

        dao.create(c);
    }

    public List<Commentaire> getCommentaires() {
        CommentaireDao commentaireDao = new CommentaireDaoImpl(em, utx);
        return commentaireDao.getCommentaires();
    }
}
