package fr.epsi.service.Categorie;

import fr.epsi.dao.Categorie.CategorieDao;
import fr.epsi.dao.Categorie.CategorieDaoImpl;
import fr.epsi.dto.CategorieDTO;
import fr.epsi.entite.Categorie;

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
public class CategorieServiceImpl implements CategorieService {

      @PersistenceContext
      EntityManager em;

      @Resource
      UserTransaction utx;

      public void create(CategorieDTO cat)  {

            Categorie c = new Categorie();
            c.setNom(cat.getNom());
            CategorieDao dao =new CategorieDaoImpl(em, utx);

            dao.create(c);
      }

      @Override
      public Categorie getById(Long idcat) {
            return em.find(Categorie.class, idcat);
      }

      public List<Categorie> getCategories() {
            CategorieDao CategorieDao = new CategorieDaoImpl(em, utx);
            return CategorieDao.getCategories();
      }


}