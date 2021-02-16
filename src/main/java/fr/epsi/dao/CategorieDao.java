package fr.epsi.dao;

import fr.epsi.entite.Categorie;

import java.util.List;

public interface CategorieDao {
    void create(Categorie c);

    List<Categorie> getCategories();
}
