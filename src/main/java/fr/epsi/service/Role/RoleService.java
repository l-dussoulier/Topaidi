package fr.epsi.service.Role;

import fr.epsi.dto.RoleDTO;
import fr.epsi.entite.Idee;
import fr.epsi.entite.Role;

import java.util.List;

public interface RoleService {
    void create(RoleDTO r);
    List<Role> getRoles();
    Role getById(Long id);

    Role LastRole();
}
