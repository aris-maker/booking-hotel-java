package dao;

import config.DatabaseConfig;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO {

    public User save(User user) {
        try (Connection conn = DatabaseConfig.getConnection()) {

            System.out.println("Saving user: " + user.getUsername());

            String sql = "INSERT INTO users(username, role) VALUES (?, ?)";
            PreparedStatement ps =
                conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getRole());

            int affectedRows = ps.executeUpdate();
            System.out.println("Rows inserted: " + affectedRows);

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                System.out.println("User saved with ID: " + rs.getInt(1));
            }

            return user;

        } catch (Exception e) {
            e.printStackTrace(); // WAJIB untuk debug
        }
        return null;
    }
}
