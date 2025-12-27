package model;

public class Booking {
    private User user;
    private Room room;
    private int nights;

    public Booking(User user, Room room, int nights) {
        this.user = user;
        this.room = room;
        this.nights = nights;
    }

    public void showBookingInfo() {
        System.out.println(
            user.getUsername() +
            " booked room " +
            room.getRoomNumber() +
            " for " +
            nights + " nights"
        );
    }
}
