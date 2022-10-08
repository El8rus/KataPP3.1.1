package SpringBoot.CRUDProject.service;

import SpringBoot.CRUDProject.model.User;

import java.util.List;

public interface UserService {
    void save(User user);

    void delete(Long id);

    List<User> listUsers();

    User findUserById(Long id);
}
