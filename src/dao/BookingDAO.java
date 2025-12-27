package dao;

import config.DatabaseConfig;
import model.Booking;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BookingDAO {

    public void save(Booking booking) {
        String sql = """
            INSERT INTO bookings (user_id, room_id, nights)
            VALUES (?, ?, ?)
        """;
    
        try (Connection c = DatabaseConfig.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
    
            ps.setInt(1, booking.getUser().getId());
            ps.setInt(2, booking.getRoom().getId()); // ⚠️ HARUS ID
            ps.setInt(3, booking.getNights());
    
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
