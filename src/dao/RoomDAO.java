package dao;

import config.DatabaseConfig;
import model.Room;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {

    // ===============================
    // GET ALL AVAILABLE ROOMS
    // ===============================
    public List<Room> getAvailableRooms() {
        List<Room> rooms = new ArrayList<>();

        String sql = "SELECT * FROM rooms WHERE available = 1";

        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Room room = new Room(
                        rs.getInt("id"),
                        rs.getInt("room_number"),
                        rs.getString("type"),
                        rs.getBoolean("available")
                );
                rooms.add(room);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rooms;
    }

    // ===============================
    // FIND ROOM BY ID
    // ===============================
    public Room findById(int id) {
        String sql = "SELECT * FROM rooms WHERE id = ?";
        Room room = null;

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                room = new Room(
                        rs.getInt("id"),
                        rs.getInt("room_number"),
                        rs.getString("type"),
                        rs.getBoolean("available")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return room;
    }

    // ===============================
    // UPDATE ROOM AVAILABILITY
    // ===============================
    public void updateAvailability(int roomId, boolean available) {
        String sql = "UPDATE rooms SET available = ? WHERE id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setBoolean(1, available);
            ps.setInt(2, roomId);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
