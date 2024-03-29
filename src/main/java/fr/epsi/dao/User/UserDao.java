package fr.epsi.dao.User;

import fr.epsi.entite.Role;
import fr.epsi.entite.User;

import javax.transaction.*;
import java.util.List;

public interface UserDao {
    void create(User u);
    List<User> getUsers();

    void setRole(User u,Role r,Boolean isActivate);

    List<User> getByEmailPassword(String email, String password);

      List<User> getByEmail(String email);

      void delete(User user);
}
