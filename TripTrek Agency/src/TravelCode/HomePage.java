import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Date;
import java.util.TimeZone;

public class HomePage extends JFrame implements ActionListener {
    public JPanel contentPane;
    private JButton goldPackage, silverPackage, bronzePackage;
    private JButton checkPackage, updateProfile, viewBookings;
    private JSpinner peopleSpinner;
    private JComboBox<String> destination;
    private JComboBox<String> pickup;
    private JComboBox<String> packageType;
    String name;
    String userName;

    public HomePage(String userNameFromLogin) {
        userName = userNameFromLogin;
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

        // Add profile icon in header
        ImageIcon profileIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/profileIcon.png"));
        Image profileImage = profileIcon.getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT);
        ImageIcon img = new ImageIcon(profileImage);
        JLabel imgLabel = new JLabel(img);
        imgLabel.setBounds(880, 12, 100, 90);
        header.add(imgLabel);

        // Display name
        JLabel userLabel = new JLabel("Name:   " + name);
        userLabel.setForeground(Color.BLACK);
        userLabel.setFont(new Font("Georgia", Font.BOLD, 16));
        userLabel.setBounds(990, 5, 200, 30);
        header.add(userLabel);

        // Add button for updating profile
        updateProfile = new JButton("Update Personal Details");
        updateProfile.setFont(new Font("Georgia", Font.BOLD, 14));
        updateProfile.setBounds(990, 35, 215, 30);
        updateProfile.addActionListener(this);
        header.add(updateProfile);

        // Add View Bookings button
        viewBookings = new JButton("View Bookings");
        viewBookings.setFont(new Font("Georgia", Font.BOLD, 14));
        viewBookings.setBounds(990, 75, 215, 30);
        viewBookings.addActionListener(this);
        header.add(viewBookings);

        // Add vacation videos
        ImageIcon bgImgIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/LoginBg.gif"));
        JLabel bgLabel = new JLabel(bgImgIcon);
        bgLabel.setBounds(50, 120, 580, 200);
        contentPane.add(bgLabel);

        // Add destination icon
        ImageIcon destinationIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/destinationIcon.jpg"));
        Image destinationImage = destinationIcon.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
        ImageIcon destinationImg = new ImageIcon(destinationImage);
        JLabel destinationImgLabel = new JLabel(destinationImg);
        destinationImgLabel.setBounds(50, 320, 100, 80);
        contentPane.add(destinationImgLabel);

        // Select destination
        JLabel destinationLabel = new JLabel("Select Destination:");
        destinationLabel.setForeground(Color.BLACK);
        destinationLabel.setFont(new Font("Georgia", Font.BOLD, 18));
        destinationLabel.setBounds(130, 345, 200, 30);
        contentPane.add(destinationLabel);

        // Add dropdown menu for destinations
        String[] destinations = { "Wayanad, Kerala", "Alleppey, Kerala", "Gokarna, Karnataka" };
        destination = new JComboBox<>(destinations);
        destination.setFont(new Font("Georgia", Font.PLAIN, 16));
        destination.setBounds(350, 345, 200, 30);
        contentPane.add(destination);

        // Add pickup icon
        ImageIcon pickupIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/pickupIcon.png"));
        Image pickupImage = pickupIcon.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
        ImageIcon pickupImg = new ImageIcon(pickupImage);
        JLabel pickupImgLabel = new JLabel(pickupImg);
        pickupImgLabel.setBounds(50, 380, 100, 80);
        contentPane.add(pickupImgLabel);

        // Add pickup point
        JLabel pickupLabel = new JLabel("Select Pickup Point:");
        pickupLabel.setForeground(Color.BLACK);
        pickupLabel.setFont(new Font("Georgia", Font.BOLD, 18));
        pickupLabel.setBounds(130, 405, 200, 30);
        contentPane.add(pickupLabel);

        // Add dropdown menu for pickup points
        String[] pickupPoints = { "Nearest Bus Stop", "Nearest Railway Station", "Nearest Airport" };
        pickup = new JComboBox<>(pickupPoints);
        pickup.setFont(new Font("Georgia", Font.PLAIN, 16));
        pickup.setBounds(350, 405, 200, 30);
        contentPane.add(pickup);

        // Add package icon
        ImageIcon packageIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/packageTypeIcon.jpg"));
        Image packageImage = packageIcon.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
        ImageIcon packageImg = new ImageIcon(packageImage);
        JLabel packageImgLabel = new JLabel(packageImg);
        packageImgLabel.setBounds(50, 440, 100, 80);
        contentPane.add(packageImgLabel);

        // Select package
        JLabel packageLabel = new JLabel("Select Package Type:");
        packageLabel.setForeground(Color.BLACK);
        packageLabel.setFont(new Font("Georgia", Font.BOLD, 18));
        packageLabel.setBounds(130, 465, 200, 30);
        contentPane.add(packageLabel);

        // Add dropdown menu for packages
        String[] packages = { "Gold", "Silver", "Bronze" };
        packageType = new JComboBox<>(packages);
        packageType.setFont(new Font("Georgia", Font.PLAIN, 16));
        packageType.setBounds(350, 465, 200, 30);
        contentPane.add(packageType);

        // No. of people icon
        ImageIcon peopleIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/peopleIcon.png"));
        Image peopleImage = peopleIcon.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
        ImageIcon peopleImg = new ImageIcon(peopleImage);
        JLabel peopleImgLabel = new JLabel(peopleImg);
        peopleImgLabel.setBounds(50, 500, 100, 80);
        contentPane.add(peopleImgLabel);

        // Add number of people
        JLabel peopleLabel = new JLabel("No. of People:");
        peopleLabel.setForeground(Color.BLACK);
        peopleLabel.setFont(new Font("Georgia", Font.BOLD, 18));
        peopleLabel.setBounds(130, 525, 200, 30);
        contentPane.add(peopleLabel);

        // Add a number spinner for selecting number of people
        peopleSpinner = new JSpinner(new SpinnerNumberModel(5, 1, 50, 1));
        peopleSpinner.setFont(new Font("Georgia", Font.PLAIN, 16));
        peopleSpinner.setBounds(350, 525, 200, 30);
        peopleSpinner.setEditor(new JSpinner.DefaultEditor(peopleSpinner));
        contentPane.add(peopleSpinner);

        // Add book package button
        checkPackage = new JButton("Book Package");
        checkPackage.setFont(new Font("Georgia", Font.BOLD, 14));
        checkPackage.setBounds(250, 585, 150, 30);
        checkPackage.setBackground(new Color(16, 189, 178));
        checkPackage.addActionListener(this);
        contentPane.add(checkPackage);

        // Add check package details label
        JLabel packageDetails = new JLabel("Check Package Details:");
        packageDetails.setForeground(Color.BLACK);
        packageDetails.setFont(new Font("Times New Roman", Font.BOLD, 18));
        packageDetails.setBounds(690, 150, 250, 30);
        contentPane.add(packageDetails);

        // Add gold package details button
        goldPackage = new JButton("Gold Package");
        goldPackage.setFont(new Font("Georgia", Font.BOLD, 14));
        goldPackage.setBounds(700, 200, 150, 30);
        goldPackage.addActionListener(this);
        contentPane.add(goldPackage);

        // Add silver package details button
        silverPackage = new JButton("Silver Package");
        silverPackage.setFont(new Font("Georgia", Font.BOLD, 14));
        silverPackage.setBounds(870, 200, 150, 30);
        silverPackage.addActionListener(this);
        contentPane.add(silverPackage);

        // Add bronze package details button
        bronzePackage = new JButton("Bronze Package");
        bronzePackage.setFont(new Font("Georgia", Font.BOLD, 14));
        bronzePackage.setBounds(1040, 200, 150, 30);
        bronzePackage.addActionListener(this);
        contentPane.add(bronzePackage);

        // Add background image
        ImageIcon bgImg = new ImageIcon(ClassLoader.getSystemResource("Icons/homePgBg.jpg"));
        Image imgBg = bgImg.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon background = new ImageIcon(imgBg);

        JLabel bgLabel1 = new JLabel(background);
        bgLabel1.setBounds(700, 250, 600, 400);
        contentPane.add(bgLabel1);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == goldPackage) {
                // Display Gold Package Details in a pop-up window using html
                JOptionPane.showMessageDialog(null,
                        "<html><div style='font-family: Georgia; font-size: 12px;'><b><i>Gold Package:</i></b><br></div>"
                                +
                                "<div style='font-family: Georgia; font-size: 12px;'><ul><li>Transportation: AC luxury vehicles for sightseeing and transfers.</li>"
                                +
                                "<div style='font-family: Georgia; font-size: 12px;'><ul><li>Exclusive guide: Professional guide provided for personalized tours.</li>"
                                +
                                "<div style='font-family: Georgia; font-size: 12px;'><ul><li>Access to Swimming Pool: Relax and unwind at the swimming pool at selected accommodations.</li>"
                                +
                                "<div style='font-family: Georgia; font-size: 12px;'><ul><li>Campfire: Gather around a cozy campfire under the starlit sky for memorable evenings.</li>"
                                +
                                "<div style='font-family: Georgia; font-size: 12px;'><ul><li>Assistance: Our team is available round the clock to assist you with any queries or concerns.</li></html>",
                        "Gold Package Details", JOptionPane.INFORMATION_MESSAGE);

            } else if (e.getSource() == silverPackage) {
                // Display Silver Package Details in a pop-up window using html
                JOptionPane.showMessageDialog(null,
                        "<html><div style='font-family: Georgia; font-size: 12px;'><b><i>Silver Package:</i></b><br></div>"
                                +
                                "<div style='font-family: Georgia; font-size: 12px;'><ul><li>Transportation: Comfortable AC vehicles for sightseeing convenience.</li>"
                                +
                                "<div style='font-family: Georgia; font-size: 12px;'><ul><li>Guide: Basic guidance provided by our friendly staff during key attractions.</li>"
                                +
                                "<div style='font-family: Georgia; font-size: 12px;'><ul><li>Access to Swimming Pool: Limited access to swimming pool facilities at accommodations.</li>"
                                +
                                "<div style='font-family: Georgia; font-size: 12px;'><ul><li>Campfire: Occasional campfire experiences, subject to availability.</li>"
                                +
                                "<div style='font-family: Georgia; font-size: 12px;'><ul><li>Assistance: Assistance available during business hours for your convenience.</li></html>",
                        "Silver Package Details", JOptionPane.INFORMATION_MESSAGE);
            } else if (e.getSource() == bronzePackage) {
                // Display Bronze Package Details in a pop-up window using html
                JOptionPane.showMessageDialog(null,
                        "<html><div style='font-family: Georgia; font-size: 12px;'><b><i>Bronze Package:</i></b><br></div>"
                                +
                                "<div style='font-family: Georgia; font-size: 12px;'><ul><li>Transportation: Non-AC vehicles for an economical travel experience.</li>"
                                +
                                "<div style='font-family: Georgia; font-size: 12px;'><ul><li>Guide: General information available at major sites, with optional guided tours at extra cost.</li>"
                                +
                                "<div style='font-family: Georgia; font-size: 12px;'><ul><li>Access to Swimming Pool: No access to swimming pool facilities at accommodations.</li>"
                                +
                                "<div style='font-family: Georgia; font-size: 12px;'><ul><li>Campfire: Campfire experiences not included in this package.</li>"
                                +
                                "<div style='font-family: Georgia; font-size: 12px;'><ul><li>Assistance: Limited assistance available during business hours.</li></html>",
                        "Bronze Package Details", JOptionPane.INFORMATION_MESSAGE);
            } else if (e.getSource() == checkPackage) {
                // Get selected destination
                String selectedDestination = (String) destination.getSelectedItem();

                // Get selected package type
                String selectedPackage = (String) packageType.getSelectedItem();

                // Get number of people
                int people = (int) peopleSpinner.getValue();

                // Get selected pickup point
                String selectedPickup = (String) pickup.getSelectedItem();

                // Open Package Page
                this.setVisible(false);
                new PackagePage(userName, selectedDestination, selectedPackage, people, selectedPickup);

            } else if (e.getSource() == updateProfile) {
                // Open Update Details Page
                new UpdateDetails(userName).isAlwaysOnTop();
            } else if (e.getSource() == viewBookings) {
                // Open View Bookings Page
                new ViewBookings(userName).isAlwaysOnTop();
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }

    public static void main(String[] args) {
        HomePage home = new HomePage("k_15");
        home.setVisible(true);

    }

}
