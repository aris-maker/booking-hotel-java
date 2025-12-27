package service;

import model.Booking;
import dao.BookingDAO;
import model.Room;
import model.User;

public class BookingService {

    private BookingDAO bookingDAO = new BookingDAO();

    public Booking bookRoom(User user, Room room, int nights) {
        if (!room.isAvailable()) {
            System.out.println("Room is not available!");
            return null;
        }

        Booking booking = new Booking(user, room, nights);

        // SIMPAN KE DATABASE
        bookingDAO.save(booking);

        // update status kamar (opsional, nanti kita rapikan)
        room.setAvailable(false);

        return booking;
    }
}
