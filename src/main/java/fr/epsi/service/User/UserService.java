package fr.epsi.service.User;

import fr.epsi.dto.UserDTO;
import fr.epsi.entite.Role;
import fr.epsi.entite.User;

import java.util.List;

public interface UserService {
    void create(UserDTO u);
    List<User> getUsers();
    User getById(Long id);
    void setRole(User u,Role r);

    List<User> getByEmailPassword(String email,String password);


}
