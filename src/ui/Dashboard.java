package ui;

import model.Room;
import model.User;
import service.RoomService;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Dashboard extends JFrame {

    private User user;
    private RoomService roomService = new RoomService();

    public Dashboard(User user) {
        this.user = user;

        setTitle("Dashboard");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel welcome = new JLabel("Welcome, " + user.getUsername());
        add(welcome, BorderLayout.NORTH);

        List<Room> rooms = roomService.getAvailableRooms();
        JTable table = new JTable(new RoomTableModel(rooms));
        add(new JScrollPane(table), BorderLayout.CENTER);

        JButton bookBtn = new JButton("Book Room");
        add(bookBtn, BorderLayout.SOUTH);
    }
}
