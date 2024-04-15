import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class ViewBookings extends JFrame {

    ViewBookings(String username) {
        try {
            Connectivity con = new Connectivity();
            String query = "select * from Bookings where username = '" + username + "'";

            ResultSet rs = con.s.executeQuery(query);

            // Create a DefaultTableModel object
            DefaultTableModel model = new DefaultTableModel() {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            model.addColumn("Booking ID");
            model.addColumn("Destination");
            model.addColumn("Hotel booked");
            model.addColumn("Check-in date");
            model.addColumn("Check-out date");
            model.addColumn("Number of people");
            model.addColumn("Amount paid");

            boolean hasData = false;

            while (rs.next()) {
                String bookingID = rs.getString("booking_id");
                String destination = rs.getString("destination");
                String hotel = rs.getString("hotel");
                String checkIn = rs.getString("check_in_date");
                String checkOut = rs.getString("check_out_date");
                String people = rs.getString("no_of_people");
                String amount = rs.getString("total_price");

                model.addRow(
                        new Object[] { bookingID, destination, hotel, checkIn, checkOut, people, "Rs. " + amount });
                hasData = true;
            }

            if (!hasData) {
                JOptionPane.showMessageDialog(null, "No bookings found", "View Bookings",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JTable table = new JTable(model);
                table.setSize(1200, 500);
                table.setRowHeight(30);
                table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                table.setDefaultRenderer(String.class, centerRenderer);

                for (int i = 0; i < table.getColumnCount(); i++) {
                    table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
                }

                table.getColumnModel().getColumn(0).setPreferredWidth(100);
                table.getColumnModel().getColumn(1).setPreferredWidth(200);
                table.getColumnModel().getColumn(2).setPreferredWidth(200);
                table.getColumnModel().getColumn(3).setPreferredWidth(200);
                table.getColumnModel().getColumn(4).setPreferredWidth(200);
                table.getColumnModel().getColumn(5).setPreferredWidth(200);
                table.getColumnModel().getColumn(6).setPreferredWidth(200);

                JScrollPane scrollPane = new JScrollPane(table);

                // Add the scroll pane to the frame
                add(scrollPane);
                setTitle("View Bookings");
                setSize(1200, 500);
                setLocationRelativeTo(scrollPane);
                setVisible(true);
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

    }

    public static void main(String[] args) {
        new ViewBookings("premika");
    }
}
