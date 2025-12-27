package model;

public class Room {
    private int id;
    private int roomNumber;
    private String type;
    private boolean available;

    public Room(int id, int roomNumber, String type, boolean available) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.type = type;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getType() {
        return type;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
