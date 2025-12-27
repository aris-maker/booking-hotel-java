package ui;

import model.Room;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class RoomTableModel extends AbstractTableModel {
    
    private final String[] columns = {"Room Number", "Type", "Available"};
    private List<Room> rooms;

    public RoomTableModel(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public int getRowCount() {
        return rooms.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int col) {
        return columns[col];
    }

    @Override
    public Object getValueAt(int row, int col) {
        Room r = rooms.get(row);
        return switch (col) {
            case 0 -> r.getRoomNumber();
            case 1 -> r.getType();
            case 2 -> r.isAvailable();
            default -> null;
        };
    }

    public Room getRoomAt(int row) {
        return rooms.get(row);
    }
}
