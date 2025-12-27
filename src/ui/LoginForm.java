package ui;

import service.AuthService;
import model.User;

import javax.swing.*;
import java.awt.*;

public class LoginForm extends JFrame {

    private JTextField usernameField;
    private AuthService authService = new AuthService();

    public LoginForm() {
        setTitle("Hotel Booking - Login");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));

        panel.add(new JLabel("Username"));
        usernameField = new JTextField();
        panel.add(usernameField);

        JButton loginButton = new JButton("Login");
        panel.add(loginButton);

        add(panel);

        loginButton.addActionListener(e -> login());
    }

    private void login() {
        String username = usernameField.getText();

        User user = authService.login(username);

        if (user != null) {
            JOptionPane.showMessageDialog(this,
                    "Login berhasil: " + user.getUsername());
            dispose();
            // next: open Dashboard
        } else {
            JOptionPane.showMessageDialog(this,
                    "Login gagal",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
