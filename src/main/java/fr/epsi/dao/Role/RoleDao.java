package fr.epsi.dao.Role;

import fr.epsi.entite.Role;
import fr.epsi.entite.User;

import java.util.List;

public interface RoleDao {
    void create(Role r);
    List<Role> getRoles();


}
