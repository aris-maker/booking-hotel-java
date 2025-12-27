package main;

import model.Booking;
import model.Room;
import model.User;
import service.AuthService;
import service.RoomService;
import service.BookingService;


import java.util.List;

public class Main {
    public static void main(String[] args) {

        AuthService authService = new AuthService();
        RoomService roomService = new RoomService();
        BookingService bookingService = new BookingService();

        User user = authService.login("ares");

        System.out.println("Available Rooms:");
        List<Room> rooms = roomService.getAvailableRooms();
        for (Room r : rooms) {
            System.out.println(r.getRoomNumber() + " - " + r.getType());
        }

        Room selectedRoom = roomService.findRoom(101);
        Booking booking = bookingService.bookRoom(user, selectedRoom, 2);

        if (booking != null) {
            booking.showBookingInfo();
        }
    }
}
