package isneverdead.farizspring3.service;

import isneverdead.farizspring3.model.Role;
import isneverdead.farizspring3.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String email, String roleName);
    User getUser(String email);
    List<User>getUsers();


}
