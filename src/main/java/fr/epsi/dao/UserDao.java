package fr.epsi.dao;

import fr.epsi.entite.User;

import java.util.List;

public interface UserDao {
    void create(User u);
    List<User> getUsers();
}
