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

    public User getUser() {
        return user;
    }

    public Room getRoom() {
        return room;
    }

    public int getNights() {
        return nights;
    }
}
