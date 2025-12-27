package service;

import dao.UserDAO;
import model.User;

public class AuthService {

    private UserDAO userDAO = new UserDAO();

    public User login(String username) {
        String role = username.equalsIgnoreCase("admin") ? "ADMIN" : "GUEST";
        User user = new User(username, role);
        return userDAO.save(user);
    }
}
