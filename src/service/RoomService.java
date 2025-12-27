package service;

import dao.RoomDAO;
import model.Room;

import java.util.List;

public class RoomService {

    private RoomDAO roomDAO = new RoomDAO();

    // ===============================
    // GET AVAILABLE ROOMS
    // ===============================
    public List<Room> getAvailableRooms() {
        return roomDAO.getAvailableRooms();
    }

    // ===============================
    // FIND ROOM BY ID
    // ===============================
    public Room findRoomById(int id) {
        return roomDAO.findById(id);
    }

    // ===============================
    // UPDATE ROOM AVAILABILITY
    // ===============================
    public void setRoomAvailability(int roomId, boolean available) {
        roomDAO.updateAvailability(roomId, available);
    }
}
