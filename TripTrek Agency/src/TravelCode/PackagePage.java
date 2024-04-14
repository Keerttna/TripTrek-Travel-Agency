import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Date;
import java.util.TimeZone;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PackagePage extends JFrame implements ActionListener {
    JPanel contentPane;
    String name, userName, destination, selectedPackage, selectedPickUp;
    int people;    
    JButton back, book3Day, book5Day, book7Day;
    JLabel itenary3Details, itenary5Details, itenary7Details;

    PackagePage(String userNameFromLogin, String destinationFromHomepg, String selectedPackageFromHome, int peopleFromHomePg, String selectedPickUpFromHomePg) {
        userName = userNameFromLogin;
        destination = destinationFromHomepg;
        selectedPackage = selectedPackageFromHome;
        people = peopleFromHomePg;
        selectedPickUp = selectedPickUpFromHomePg;

        try {
            Connectivity conn = new Connectivity();
            String query = "SELECT * FROM Account WHERE username = '" + userName + "' ";

            ResultSet rs = conn.s.executeQuery(query);
            rs.next();
            name = rs.getString("name");
        } catch (SQLException e) {
            // Handle the exception
            e.printStackTrace();
        }

        setSize(1280, 720);
        setTitle("TripTrek Agency");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Add Header
        JPanel header = new JPanel();
        header.setBackground(new Color(32, 178, 170));
        header.setBounds(0, 0, 1280, 110);
        header.setLayout(null);
        contentPane.add(header);

        // Add Logo in header
        ImageIcon logoIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/logo.png"));
        Image logoImage = logoIcon.getImage().getScaledInstance(200, 110, Image.SCALE_SMOOTH);
        ImageIcon logoimg = new ImageIcon(logoImage);
        JLabel logoimgLabel = new JLabel(logoimg);
        logoimgLabel.setBounds(0, 0, 200, 110);
        header.add(logoimgLabel);

        // Display current date and day
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        DayOfWeek day = DayOfWeek.from(date.toInstant().atZone(TimeZone.getDefault().toZoneId()).toLocalDate());

        JLabel dateLabel = new JLabel(formatDate.format(date) + "       " + day.toString());
        dateLabel.setForeground(Color.BLACK);
        dateLabel.setFont(new Font("Georgia", Font.BOLD, 16));
        dateLabel.setBounds(230, 15, 400, 30);
        contentPane.add(dateLabel);
        header.add(dateLabel);

        // Add a about us button in header
        JButton aboutUs = new JButton("About Us");
        aboutUs.setFont(new Font("Georgia", Font.BOLD, 14));
        aboutUs.setBounds(270, 60, 100, 30);
        header.add(aboutUs);

        // Add detination name in header
        JLabel destinationLabel = new JLabel(destination.toUpperCase());
        destinationLabel.setForeground(Color.BLACK);
        destinationLabel.setFont(new Font("Georgia", Font.BOLD, 20));
        destinationLabel.setBounds(530, 40, 400, 30);
        header.add(destinationLabel);

        // Add profile icon in header
        ImageIcon profileIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/profileIcon.png"));
        Image profileImage = profileIcon.getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT);
        ImageIcon img = new ImageIcon(profileImage);
        JLabel imgLabel = new JLabel(img);
        imgLabel.setBounds(1000, 5, 90, 90);
        header.add(imgLabel);

        // Display name
        JLabel userLabel = new JLabel("Name:   " + name);
        userLabel.setForeground(Color.BLACK);
        userLabel.setForeground(Color.BLACK);
        userLabel.setFont(new Font("Georgia", Font.BOLD, 16));
        userLabel.setBounds(1090, 25, 200, 30);
        header.add(userLabel);

        // Add back button in header
        back = new JButton("Back");
        back.setFont(new Font("Georgia", Font.BOLD, 14));
        back.setBounds(1100, 60, 100, 30);
        back.addActionListener(this);
        header.add(back);

        // Display itinerary details using html
        if (destination.equals("Wayanad, Kerala")) {
            itenary3Details = new JLabel(
                    "<html> <div style='font-family: Georgia;font-size: 14px;text-align: center'> 3 Day Itinerary </div><br>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 1: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit to Edakkal Caves</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Soochipara Waterfalls</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Banasura Sagar Dam</li></ul>"

                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 2: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit to Chembra Peak</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Pookode Lake</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Lakkidi View Point</li></ul>"

                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 3: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit to Thirunelli Temple</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Kuruva Island</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Muthanga Wildlife Sanctuary</li></ul></html>");

            itenary5Details = new JLabel(
                    "<html> <div style='font-family: Georgia;font-size: 14px;text-align: center'> 5 Day Itinerary </div><br>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 1: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit to Edakkal Caves</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Soochipara Waterfalls</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Banasura Sagar Dam</li></ul>"

                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 2: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit to Chembra Peak</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Pookode Lake</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Lakkidi View Point</li></ul>"

                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 3: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit to Thirunelli Temple</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Kuruva Island</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Muthanga Wildlife Sanctuary</li></ul>"

                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 4: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit to Pakshipathalam</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Meenmutty Waterfalls</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Tholpetty Wildlife Sanctuary</li></ul>"

                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 5: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit Wayanad Heritage Museum</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>En Ooru Village</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Karapuzha Dam</li></ul> </html>");

            itenary7Details = new JLabel(
                    "<html> <div style='font-family: Georgia;font-size: 14px;text-align: center'> 7 Day Itinerary </div><br>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 1: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit to Edakkal Caves</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Soochipara Waterfalls</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Banasura Sagar Dam</li></ul>"

                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 2: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit to Chembra Peak</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Pookode Lake</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Lakkidi View Point</li></ul>"

                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 3: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit to Thirunelli Temple</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Kuruva Island</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Muthanga Wildlife Sanctuary</li></ul>"

                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 4: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit to Pakshipathalam</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Meenmutty Waterfalls</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Tholpetty Wildlife Sanctuary</li></ul>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 5: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit Wayanad Heritage Museum</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>En Ooru Village</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Karapuzha Dam</li></ul>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 6: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit to Thusharagiri Waterfalls</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Chain Tree</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Neelimala View Point</li></ul>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 7: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit to Kuruvadweep</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Shopping at local markets</li></ul> </html>");

        } else if (destination.equals("Allepey, Kerala")) {
            itenary3Details = new JLabel(
                    "<html><div style='font-family: Georgia;font-size: 14px;text-align: center'> 3 Day Itinerary </div><br>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 1: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit to Alappuzha Beach</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Alappuzha Lighthouse</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Marari Beach</li></ul>"

                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 2: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit to Krishnapuram Palace</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Pathiramanal Island</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>St. Mary's Forane Church</li></ul>"

                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 3: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit to Ambalapuzha Temple</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Revi Karunakaran Museum</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Chettikulangara Bhagavathy Temple</li></ul></html>");

            itenary5Details = new JLabel(
                    "<html><div style='font-family: Georgia;font-size: 14px;text-align: center'> 5 Day Itinerary </div><br>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 1: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit to Alappuzha Beach</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Alappuzha Lighthouse</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Marari Beach</li></ul>"

                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 2: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit to Krishnapuram Palace</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Pathiramanal Island</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>St. Mary's Forane Church</li></ul>"

                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 3: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit to Ambalapuzha Temple</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Revi Karunakaran Museum</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Chettikulangara Bhagavathy Temple</li></ul></html>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 4: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit to Ambalapuzha Temple</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Revi Karunakaran Museum</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Chettikulangara Bhagavathy Temple</li></ul>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 5: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit to Ambalapuzha Temple</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Revi Karunakaran Museum</li>");

            itenary7Details = new JLabel(
                    "<html><html> <div style='font-family: Georgia;font-size: 14px;text-align: center'> 7 Day Itinerary </div><br>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 1: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit to Alappuzha Beach</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Alappuzha Lighthouse</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Marari Beach</li></ul>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 2: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit to Krishnapuram Palace</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Pathiramanal Island</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>St. Mary's Forane Church</li></ul>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 3: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit to Ambalapuzha Temple</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Revi Karunakaran Museum</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Chettikulangara Bhagavathy Temple</li></ul>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 4: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit to Ambalapuzha Temple</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Revi Karunakaran Museum</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Chettikulangara Bhagavathy Temple</li></ul>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 6: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit to Thusharagiri Waterfalls</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Chain Tree</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Neelimala View Point</li></ul>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 7: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit to Kuruvadweep</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Shopping at local markets</li></ul> </html>");

        } else if (destination.equals("Gokarna, Karnataka")) {
            itenary3Details = new JLabel(
                    "<html><html> <div style='font-family: Georgia;font-size: 14px;text-align: center'> 3 Day Itinerary </div><br>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 1: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit to Om Beach</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Half Moon Beach</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Paradise Beach</li></ul>"

                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 2: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit to Kudle Beach</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Mirjan Fort</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Shiva Cave</li></ul>"

                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 3: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit to Mahabaleshwar Temple</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Yana Caves</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Mirjan Fort</li></ul></html>");

            itenary5Details = new JLabel(
                    "<html><html> <div style='font-family: Georgia;font-size: 14px;text-align: center'> 5 Day Itinerary </div><br>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 1: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit to Om Beach</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Half Moon Beach</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Paradise Beach</li></ul>"

                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 2: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit to Kudle Beach</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Mirjan Fort</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Shiva Cave</li></ul>"

                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 3: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit to Mahabaleshwar Temple</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Yana Caves</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Mirjan Fort</li></ul>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 4: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit to Mahabaleshwar Temple</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Yana Caves</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Mirjan Fort</li></ul>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 5: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit to Mahabaleshwar Temple</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Yana Caves</li>");

            itenary7Details = new JLabel(
                    "<html><html> <div style='font-family: Georgia;font-size: 14px;text-align: center'> 7 Day Itinerary </div><br>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 1: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit to Om Beach</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Half Moon Beach</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Paradise Beach</li></ul>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 2: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit to Kudle Beach</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Mirjan Fort</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Shiva Cave</li></ul>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 3: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit to Mahabaleshwar Temple</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Yana Caves</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Mirjan Fort</li></ul>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 4: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit to Mahabaleshwar Temple</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Yana Caves</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Mirjan Fort</li></ul>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 5: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit to Mahabaleshwar Temple</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Yana Caves</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Mirjan Fort</li></ul>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 6: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit to Thusharagiri Waterfalls</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Chain Tree</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Neelimala View Point</li></ul>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><b><i>Day 7: </i></b><br></div>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><ul><li>Visit to Kuruvadweep</li>"
                            + "<div style='font-family: Georgia; font-size: 11px;'><li>Shopping at local markets</li></ul></html>");
        }

        // Add a panel for displaying 3 day itenary
        JPanel itenary3Panel = new JPanel();
        itenary3Panel.setBounds(20, 130, 395, 440);
        Border border = new LineBorder(Color.BLACK, 2);
        itenary3Panel.setBorder(border);
        itenary3Panel.setLayout(null);

        itenary3Details.setForeground(Color.BLACK);
        itenary3Details.setBounds(40, 50, 375, 380);
        itenary3Panel.add(itenary3Details);

        JScrollPane scrollPane1 = new JScrollPane();
        scrollPane1.setBounds(0, 0, 395, 440);
        Border border1 = new LineBorder(Color.BLACK, 2);
        scrollPane1.setViewportBorder(border1);
        itenary3Panel.add(scrollPane1);

        itenary3Details.setForeground(Color.BLACK);
        itenary3Details.setBounds(435, 100, 375, 380);
        itenary3Details.setBorder(new EmptyBorder(15, 25, 20, 30));
        scrollPane1.setViewportView(itenary3Details);

        contentPane.add(itenary3Panel);

        // Add button to book 3 day package
        book3Day = new JButton("Book 3 Day Package");
        book3Day.setFont(new Font("Georgia", Font.BOLD, 14));
        book3Day.setBackground(new Color(32, 178, 170));
        book3Day.setForeground(Color.BLACK);
        book3Day.setBounds(120, 590, 200, 30);
        contentPane.add(book3Day);

        contentPane.add(itenary3Panel);

        // Add a panel with scroll bar for displaying 5 day itenary
        JPanel itenary5Panel = new JPanel();
        itenary5Panel.setBounds(435, 130, 395, 440);
        itenary5Panel.setLayout(null);

        JScrollPane scrollPane2 = new JScrollPane();
        scrollPane2.setBounds(0, 0, 395, 440);
        Border border2 = new LineBorder(Color.BLACK, 2);
        scrollPane2.setViewportBorder(border2);
        itenary5Panel.add(scrollPane2);

        itenary5Details.setForeground(Color.BLACK);
        itenary5Details.setBounds(435, 100, 375, 380);
        itenary5Details.setBorder(new EmptyBorder(15, 25, 20, 30));
        scrollPane2.setViewportView(itenary5Details);

        contentPane.add(itenary5Panel);

        // Add button to book 5 day package
        book5Day = new JButton("Book 5 Day Package");
        book5Day.setFont(new Font("Georgia", Font.BOLD, 14));
        book5Day.setBackground(new Color(32, 178, 170));
        book5Day.setForeground(Color.BLACK);
        book5Day.setBounds(530, 590, 200, 30);
        contentPane.add(book5Day);

        // Add a panel for displaying 7 day itenary
        JPanel itenary7Panel = new JPanel();
        itenary7Panel.setBounds(850, 130, 395, 440);
        itenary7Panel.setLayout(null);

        JScrollPane scrollPane3 = new JScrollPane();
        scrollPane3.setBounds(0, 0, 395, 440);
        Border border3 = new LineBorder(Color.BLACK, 2);
        scrollPane3.setViewportBorder(border3);
        itenary7Panel.add(scrollPane3);

        itenary7Details.setForeground(Color.BLACK);
        itenary7Details.setBounds(40, 50, 375, 380);
        itenary7Details.setBorder(new EmptyBorder(15, 25, 20, 30));
        scrollPane3.setViewportView(itenary7Details);

        contentPane.add(itenary7Panel);

        // Add button to book 7 day package
        book7Day = new JButton("Book 7 Day Package");
        book7Day.setFont(new Font("Georgia", Font.BOLD, 14));
        book7Day.setBackground(new Color(32, 178, 170));
        book7Day.setForeground(Color.BLACK);
        book7Day.setBounds(950, 590, 200, 30);
        contentPane.add(book7Day);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            this.setVisible(false);
            new HomePage(userName).setVisible(true);
        } else if (e.getSource() == book3Day) {
            this.setVisible(false);
            new HotelsPage(userName, destination, 3, selectedPackage, people, selectedPickUp).setVisible(true);
        } else if (e.getSource() == book5Day) {
            this.setVisible(false);
            new HotelsPage(userName, destination, 5, selectedPackage, people, selectedPickUp).setVisible(true);
        } else if (e.getSource() == book7Day) {
            this.setVisible(false);
            new HotelsPage(userName, destination, 7, selectedPackage, people, selectedPickUp).setVisible(true);
        }

    }

    public static void main(String[] args) {
        //new PackagePage("aishu", "Gokarna, Karnataka").setVisible(true);
    }

}
