package service;

import dao.UserDAO;
import model.User;

public class AuthService {

    private UserDAO userDAO = new UserDAO();

    public User login(String username) {
        User user = userDAO.findByUsername(username);

        if (user == null) {
            user = userDAO.save(username, "GUEST");
        }

        return user;
    }
}
