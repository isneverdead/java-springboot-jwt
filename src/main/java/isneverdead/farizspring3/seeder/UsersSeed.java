package isneverdead.farizspring3.seeder;

import isneverdead.farizspring3.model.Role;
import isneverdead.farizspring3.model.User;
import isneverdead.farizspring3.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class UsersSeed {
    @Bean
    CommandLineRunner createUsers(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "USER"));
            userService.saveRole(new Role(null, "MANAGER"));
            userService.saveRole(new Role(null, "ADMIN"));
            userService.saveRole(new Role(null, "SUPER_ADMIN"));

            userService.saveUser(new User(null, "Fariz", "fariz@email.com", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Akbar", "akbar@email.com", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Akbur", "akbur@email.com", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Akbir", "akbir@email.com", "1234", new ArrayList<>()));

            userService.addRoleToUser("fariz@email.com", "SUPER_ADMIN");
            userService.addRoleToUser("fariz@email.com", "MANAGER");
            userService.addRoleToUser("akbar@email.com", "USER");
            userService.addRoleToUser("akbur@email.com", "MANAGER");
            userService.addRoleToUser("akbir@email.com", "ADMIN");
        };
    }
}
