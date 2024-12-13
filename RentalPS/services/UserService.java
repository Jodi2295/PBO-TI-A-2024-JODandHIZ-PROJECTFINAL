package RentalPS.services;

import RentalPS.entities.User;
import RentalPS.repositories.UserRepository;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean login(String username, String password) {
        User user = userRepository.findUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    public boolean register(String username, String password) {
        if (userRepository.findUserByUsername(username) == null) {
            userRepository.addUser(new User(username, password));
            return true;
        }
        return false;
    }
}