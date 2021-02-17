package fr.epsi.service.Categorie;


import fr.epsi.dto.CategorieDTO;
import fr.epsi.entite.Categorie;

import java.util.List;

public interface CategorieService {
    void create(CategorieDTO i);

    Categorie getById(Long idcat);

    List<Categorie> getCategories();
}
