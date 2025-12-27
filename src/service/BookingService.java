package service;

import model.Booking;
import model.Room;
import model.User;

public class BookingService {

    public Booking bookRoom(User user, Room room, int nights) {
        if (!room.isAvailable()) {
            System.out.println("Room is not available!");
            return null;
        }

        room.setAvailable(false);
        return new Booking(user, room, nights);
    }
}
