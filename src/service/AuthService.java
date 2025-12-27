package service;

import model.User;

public class AuthService {

    public User login(String username) {
        if (username.equalsIgnoreCase("admin")) {
            return new User(username, "ADMIN");
        }
        return new User(username, "GUEST");
    }
}
