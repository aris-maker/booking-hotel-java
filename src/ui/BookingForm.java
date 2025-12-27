package ui;

import model.Room;
import model.User;
import service.BookingService;

import javax.swing.*;
import java.awt.*;

public class BookingForm extends JDialog {

    public BookingForm(JFrame parent, User user, Room room) {
        super(parent, "Book Room", true);

        BookingService bookingService = new BookingService();
        
        setSize(300, 200);
        setLocationRelativeTo(parent);
        setLayout(new GridLayout(3, 2, 10, 10));

        add(new JLabel("Room:"));
        add(new JLabel(room.getRoomNumber() + " - " + room.getType()));

        add(new JLabel("Nights:"));
        JTextField nightsField = new JTextField();
        add(nightsField);

        JButton bookBtn = new JButton("Confirm");
        add(bookBtn);

        bookBtn.addActionListener(e -> {
            int nights = Integer.parseInt(nightsField.getText());
            bookingService.bookRoom(user, room, nights);
            JOptionPane.showMessageDialog(this, "Booking successful!");
            dispose();
        });
    }
}
