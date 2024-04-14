import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.toedter.calendar.JDateChooser;

public class HotelsPage extends JFrame implements ActionListener {
    private JPanel contentPane;
    JButton back, checkPriceBt, confirmBooking;
    String name, userName, destination, selectedPackage, selectedPickUp;
    int people;
    int days;
    JComboBox<String> hotelList;
    JDateChooser checkInField;
    JTextField checkOutField;
    JTextField singleBedField, doubleBedField;
    ButtonGroup acGroup, foodGroup;
    JRadioButton ac, nonAc;
    JRadioButton food, noFood;
    float acPrice = 0;
    float foodPrice = 0;
    long checkInTime, checkOutTime;

    HotelsPage(String userNameFromLogin, String destinationFromHomepg, int daysFromPackage,
            String selectedPackageFromHome, int peopleFromHomePg, String selectedPickUpFromHomePg) {
        userName = userNameFromLogin;
        destination = destinationFromHomepg;
        days = daysFromPackage;
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

        if (destination.equals("Wayanad, Kerala")) {

            // Hotel 1
            ImageIcon wayanadImg1 = new ImageIcon(ClassLoader.getSystemResource("Icons/Wayanad/jungleBay.jpg"));
            Image wayanadImage1 = wayanadImg1.getImage().getScaledInstance(640, 145, Image.SCALE_DEFAULT);
            ImageIcon wayanadImgIcon1 = new ImageIcon(wayanadImage1);
            JLabel wayanadImgLabel1 = new JLabel(wayanadImgIcon1);
            wayanadImgLabel1.setBounds(35, 130, 640, 145);
            contentPane.add(wayanadImgLabel1);

            // Hotel 2
            ImageIcon wayanadImg2 = new ImageIcon(ClassLoader.getSystemResource("Icons/Wayanad/morickap.jpg"));
            Image wayanadImage2 = wayanadImg2.getImage().getScaledInstance(640, 145, Image.SCALE_DEFAULT);
            ImageIcon wayanadImgIcon2 = new ImageIcon(wayanadImage2);
            JLabel wayanadImgLabel2 = new JLabel(wayanadImgIcon2);
            wayanadImgLabel2.setBounds(35, 295, 640, 145);
            contentPane.add(wayanadImgLabel2);

            // Hotel 3
            ImageIcon wayanadImg3 = new ImageIcon(ClassLoader.getSystemResource("Icons/Wayanad/vyna.jpg"));
            Image wayanadImage3 = wayanadImg3.getImage().getScaledInstance(640, 145, Image.SCALE_DEFAULT);
            ImageIcon wayanadImgIcon3 = new ImageIcon(wayanadImage3);
            JLabel wayanadImgLabel3 = new JLabel(wayanadImgIcon3);
            wayanadImgLabel3.setBounds(35, 460, 640, 145);
            contentPane.add(wayanadImgLabel3);

        } else if (destination.equals("Gokarna, Karnataka")) {
            // Hotel 1
            ImageIcon gokarnaImg1 = new ImageIcon(ClassLoader.getSystemResource("Icons/Gokarna/samruddhi.jpg"));
            Image gokarnaImage1 = gokarnaImg1.getImage().getScaledInstance(640, 145, Image.SCALE_DEFAULT);
            ImageIcon gokarnaImgIcon1 = new ImageIcon(gokarnaImage1);
            JLabel gokarnaImgLabel1 = new JLabel(gokarnaImgIcon1);
            gokarnaImgLabel1.setBounds(35, 130, 640, 145);
            contentPane.add(gokarnaImgLabel1);

            // Hotel 2
            ImageIcon gokarnaImg2 = new ImageIcon(ClassLoader.getSystemResource("Icons/Gokarna/arthigamya.jpg"));
            Image gokarnaImage2 = gokarnaImg2.getImage().getScaledInstance(640, 145, Image.SCALE_DEFAULT);
            ImageIcon gokarnaImgIcon2 = new ImageIcon(gokarnaImage2);
            JLabel gokarnaImgLabel2 = new JLabel(gokarnaImgIcon2);
            gokarnaImgLabel2.setBounds(35, 295, 640, 145);
            contentPane.add(gokarnaImgLabel2);

            // Hotel 3
            ImageIcon gokarnaImg3 = new ImageIcon(ClassLoader.getSystemResource("Icons/Gokarna/stoneWood.jpg"));
            Image gokarnaImage3 = gokarnaImg3.getImage().getScaledInstance(640, 145, Image.SCALE_DEFAULT);
            ImageIcon gokarnaImgIcon3 = new ImageIcon(gokarnaImage3);
            JLabel gokarnaImgLabel3 = new JLabel(gokarnaImgIcon3);
            gokarnaImgLabel3.setBounds(35, 460, 640, 145);
            contentPane.add(gokarnaImgLabel3);

        } else {
            // Hotel 1
            ImageIcon allepeyImg1 = new ImageIcon(ClassLoader.getSystemResource("Icons/Allepey/VenicePremium.jpg"));
            Image allepeyImage1 = allepeyImg1.getImage().getScaledInstance(640, 145, Image.SCALE_DEFAULT);
            ImageIcon allepeyImgIcon1 = new ImageIcon(allepeyImage1);
            JLabel allepeyImgLabel1 = new JLabel(allepeyImgIcon1);
            allepeyImgLabel1.setBounds(35, 130, 640, 145);
            contentPane.add(allepeyImgLabel1);

            // Hotel 2
            ImageIcon allepeyImg2 = new ImageIcon(ClassLoader.getSystemResource("Icons/Allepey/abadTurtle.jpg"));
            Image allepeyImage2 = allepeyImg2.getImage().getScaledInstance(640, 145, Image.SCALE_DEFAULT);
            ImageIcon allepeyImgIcon2 = new ImageIcon(allepeyImage2);
            JLabel allepeyImgLabel2 = new JLabel(allepeyImgIcon2);
            allepeyImgLabel2.setBounds(35, 295, 640, 145);
            contentPane.add(allepeyImgLabel2);

            // Hotel 3
            ImageIcon allepeyImg3 = new ImageIcon(ClassLoader.getSystemResource("Icons/Allepey/sterlingLake.jpg"));
            Image allepeyImage3 = allepeyImg3.getImage().getScaledInstance(640, 145, Image.SCALE_DEFAULT);
            ImageIcon allepeyImgIcon3 = new ImageIcon(allepeyImage3);
            JLabel allepeyImgLabel3 = new JLabel(allepeyImgIcon3);
            allepeyImgLabel3.setBounds(35, 460, 640, 145);
            contentPane.add(allepeyImgLabel3);

        }

        // Book hotel frame
        JPanel panel = new JPanel();
        panel.setForeground(new Color(34, 139, 34));
        panel.setBounds(750, 130, 480, 490);
        Border border = new LineBorder(Color.BLACK, 2);
        panel.setBorder(border);
        panel.setLayout(null);

        // Add title in the top center of the panel
        JLabel title = new JLabel("Book Hotel");
        title.setFont(new Font("Georgia", Font.BOLD, 20));
        title.setBounds(180, 10, 200, 20);
        panel.add(title);

        // Add hotel icon
        ImageIcon hotelIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/hotelIcon.png"));
        Image hotelImage = hotelIcon.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
        ImageIcon hotelImg = new ImageIcon(hotelImage);
        JLabel hotelImgLabel = new JLabel(hotelImg);
        hotelImgLabel.setBounds(20, 40, 50, 40);
        panel.add(hotelImgLabel);

        // Select hotel label
        JLabel selectHotel = new JLabel("Select Hotel:");
        selectHotel.setFont(new Font("Georgia", Font.BOLD, 16));
        selectHotel.setBounds(80, 50, 200, 20);
        panel.add(selectHotel);

        if (destination.equals("Wayanad, Kerala")) {
            // Add a dropdown menu for selecting hotel
            String[] hotels = { "Jungle Bay Resort", "Morickap Resort", "Vyna Hillock Resort" };
            hotelList = new JComboBox<>(hotels);
            hotelList.setFont(new Font("Georgia", Font.PLAIN, 16));
            hotelList.setBounds(230, 50, 200, 30);
            panel.add(hotelList);
        } else if (destination.equals("Gokarna, Karnataka")) {
            // Add a dropdown menu for selecting hotel
            String[] hotels = { "Samruddhi Resort", "Arthigamya Hotels", "Stone Wood Resort" };
            hotelList = new JComboBox<>(hotels);
            hotelList.setFont(new Font("Georgia", Font.PLAIN, 16));
            hotelList.setBounds(230, 50, 200, 30);
            panel.add(hotelList);
        } else {
            // Add a dropdown menu for selecting hotel
            String[] hotels = { "Venice Premium Houseboat", "Abad Turtle Beach Resort", "Sterling Lake Palace" };
            hotelList = new JComboBox<>(hotels);
            hotelList.setFont(new Font("Georgia", Font.PLAIN, 16));
            hotelList.setBounds(230, 50, 200, 30);
            panel.add(hotelList);
        }

        // Add check-in date icon
        ImageIcon checkInIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/checkInIcon.png"));
        Image checkInImage = checkInIcon.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
        ImageIcon checkInImg = new ImageIcon(checkInImage);
        JLabel checkInImgLabel = new JLabel(checkInImg);
        checkInImgLabel.setBounds(20, 90, 50, 40);
        panel.add(checkInImgLabel);

        // Check-in date label
        JLabel checkInDate = new JLabel("Check-in Date:");
        checkInDate.setFont(new Font("Georgia", Font.BOLD, 16));
        checkInDate.setBounds(80, 100, 200, 30);
        panel.add(checkInDate);

        // Add check-in date field
        checkInField = new JDateChooser();
        checkInField.setBounds(230, 100, 200, 30);
        // Set minimum selectable date to the next date
        checkInField.setMinSelectableDate(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000));
        panel.add(checkInField);

        // Add check-out date icon
        ImageIcon checkOutIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/checkInIcon.png"));
        Image checkOutImage = checkOutIcon.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
        ImageIcon checkOutImg = new ImageIcon(checkOutImage);
        JLabel checkOutImgLabel = new JLabel(checkOutImg);
        checkOutImgLabel.setBounds(20, 140, 50, 40);
        panel.add(checkOutImgLabel);

        // Check-out date label
        JLabel checkOutDate = new JLabel("Check-out Date:");
        checkOutDate.setFont(new Font("Georgia", Font.BOLD, 16));
        checkOutDate.setBounds(80, 150, 200, 30);
        panel.add(checkOutDate);

        // Add a check-out date field
        checkOutField = new JTextField();
        checkOutField.setBounds(230, 150, 200, 30);
        checkOutField.setForeground(Color.BLACK);
        checkOutField.setBackground(Color.WHITE);
        checkOutField.setBorder(new LineBorder(Color.BLACK, 1));
        checkOutField.setEditable(false);
        panel.add(checkOutField);

        // Add listener to check-in field
        checkInField.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (checkInField.getDate() != null) {

                    // Calculate check-out date based on check-in date and number of days
                    checkInTime = checkInField.getDate().getTime();
                    checkOutTime = checkInTime + (days * 24 * 60 * 60 * 1000); // milliseconds
                    checkOutField.setText(SimpleDateFormat.getDateInstance().format(new Date(checkOutTime)));
                }
            }
        });

        // Add room type icon
        ImageIcon roomTypeIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/roomTypeIcon.png"));
        Image roomTypeImage = roomTypeIcon.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
        ImageIcon roomTypeImg = new ImageIcon(roomTypeImage);
        JLabel roomTypeImgLabel = new JLabel(roomTypeImg);
        roomTypeImgLabel.setBounds(20, 190, 50, 40);
        panel.add(roomTypeImgLabel);

        // Room type label
        JLabel roomType = new JLabel("Room Type");
        roomType.setFont(new Font("Georgia", Font.BOLD, 16));
        roomType.setBounds(80, 200, 200, 30);
        panel.add(roomType);

        // No. of rooms label
        JLabel noOfRooms = new JLabel("No. of Rooms");
        noOfRooms.setFont(new Font("Georgia", Font.BOLD, 16));
        noOfRooms.setBounds(300, 200, 200, 30);
        panel.add(noOfRooms);

        // Single bed room label
        JLabel singleBedRoom = new JLabel("\u2022 Single Bed Room");
        singleBedRoom.setFont(new Font("Georgia", Font.BOLD, 16));
        singleBedRoom.setBounds(80, 240, 200, 30);
        panel.add(singleBedRoom);

        // Add single bed room field
        singleBedField = new JTextField();
        singleBedField.setBounds(330, 240, 50, 30);
        panel.add(singleBedField);

        // Double bed room label
        JLabel doubleBedRoom = new JLabel("\u2022 Double Bed Room");
        doubleBedRoom.setFont(new Font("Georgia", Font.BOLD, 16));
        doubleBedRoom.setBounds(80, 280, 200, 30);
        panel.add(doubleBedRoom);

        // Add double bed room field
        doubleBedField = new JTextField();
        doubleBedField.setBounds(330, 280, 50, 30);
        panel.add(doubleBedField);

        // Add action listener to single bed room field
        singleBedField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update double bed room field
                try {
                    int singleBeds = Integer.parseInt(singleBedField.getText());
                    int doubleBeds = (people - singleBeds) / 2;
                    doubleBedField.setText(Integer.toString(doubleBeds));
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Add action listener to double bed room field
        doubleBedField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int doubleBeds = Integer.parseInt(doubleBedField.getText());
                    int singleBeds = people - (doubleBeds * 2);
                    singleBedField.setText(Integer.toString(singleBeds));
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Add AC/Non AC icon
        ImageIcon acIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/acIcon.png"));
        Image acImage = acIcon.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
        ImageIcon acImg = new ImageIcon(acImage);
        JLabel acImgLabel = new JLabel(acImg);
        acImgLabel.setBounds(20, 320, 50, 40);
        panel.add(acImgLabel);

        // AC/Non AC label
        JLabel acLabel = new JLabel("AC/Non AC");
        acLabel.setFont(new Font("Georgia", Font.BOLD, 16));
        acLabel.setBounds(80, 330, 200, 30);
        panel.add(acLabel);

        // Add a radio button for selecting AC/Non AC
        ac = new JRadioButton("AC");
        ac.setFont(new Font("Georgia", Font.BOLD, 16));
        ac.setBounds(230, 330, 100, 30);
        panel.add(ac);

        nonAc = new JRadioButton("Non AC");
        nonAc.setFont(new Font("Georgia", Font.BOLD, 16));
        nonAc.setBounds(330, 330, 100, 30);
        panel.add(nonAc);

        acGroup = new ButtonGroup();
        acGroup.add(ac);
        acGroup.add(nonAc);

        // Add food icon
        ImageIcon foodIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/foodIcon.png"));
        Image foodImage = foodIcon.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
        ImageIcon foodImg = new ImageIcon(foodImage);
        JLabel foodImgLabel = new JLabel(foodImg);
        foodImgLabel.setBounds(20, 370, 50, 40);
        panel.add(foodImgLabel);

        // Food label
        JLabel foodLabel = new JLabel("Food");
        foodLabel.setFont(new Font("Georgia", Font.BOLD, 16));
        foodLabel.setBounds(80, 380, 200, 30);
        panel.add(foodLabel);

        // Add a radio button for selecting food
        food = new JRadioButton("Yes");
        food.setFont(new Font("Georgia", Font.BOLD, 16));
        food.setBounds(230, 380, 100, 30);
        panel.add(food);

        noFood = new JRadioButton("No");
        noFood.setFont(new Font("Georgia", Font.BOLD, 16));
        noFood.setBounds(330, 380, 100, 30);
        panel.add(noFood);

        foodGroup = new ButtonGroup();
        foodGroup.add(food);
        foodGroup.add(noFood);

        // Add a check price button
        checkPriceBt = new JButton("Check Price");
        checkPriceBt.setFont(new Font("Georgia", Font.BOLD, 16));
        checkPriceBt.setBounds(200, 430, 150, 30);
        checkPriceBt.setBackground(new Color(32, 178, 170));
        checkPriceBt.setForeground(Color.BLACK);
        checkPriceBt.addActionListener(this);
        panel.add(checkPriceBt);

        contentPane.add(panel);

        this.setVisible(true);

    }

    public static void main(String[] args) {
        new HotelsPage("aishu", "Gokarna, Karnataka", 3, "Silver", 6, "Airport");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == back) {
                this.setVisible(false);
                new PackagePage(userName, destination, selectedPackage, people, selectedPickUp);
            } else if (e.getSource() == checkPriceBt) {

                // Data validation for number of rooms
                if (singleBedField.getText().equals("") || doubleBedField.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Please enter the number of rooms");
                    return;
                } else if (Integer.valueOf(singleBedField.getText())
                        + Integer.valueOf(doubleBedField.getText()) != people) {
                    JOptionPane.showMessageDialog(this, "Number of rooms should be equal to number of people");
                    return;
                } else if (Integer.valueOf(singleBedField.getText()) < 0
                        || Integer.valueOf(doubleBedField.getText()) < 0) {
                    JOptionPane.showMessageDialog(this, "Invalid number of rooms");
                    return;
                }

                String selectedHotel = hotelList.getSelectedItem().toString();

                Connectivity conn = new Connectivity();
                String query = "SELECT * FROM Hotels_available WHERE hotel = '" + selectedHotel + "' ";
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next() == false) {
                    JOptionPane.showMessageDialog(this, "Hotel not available");
                    return;
                }

                int noOfSingleBed = Integer.valueOf(singleBedField.getText());
                int noOfDoubleBed = Integer.valueOf(doubleBedField.getText());
                float doubleBedPrice = rs.getFloat("double_bed_cost") * noOfDoubleBed * days;
                float singleBedPrice = rs.getFloat("single_bed_cost") * noOfSingleBed * days;

                // Check if ac is selected
                if (ac.isSelected()) {
                    acPrice = rs.getFloat("ac_cost") * days;
                }

                // Check if food is selected
                if (food.isSelected()) {
                    foodPrice = rs.getFloat("food_cost") * days;
                }

                // Display the price in a new frame
                JFrame priceFrame = new JFrame();
                priceFrame.setSize(500, 500);
                priceFrame.setTitle("Price");
                priceFrame.setLayout(null);
                priceFrame.setLocationRelativeTo(null);
                priceFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);

                JLabel hotelLabel = new JLabel("Hotel: " + selectedHotel);
                hotelLabel.setFont(new Font("Georgia", Font.BOLD, 16));
                hotelLabel.setBounds(50, 50, 200, 30);
                priceFrame.add(hotelLabel);

                JLabel daysLabel = new JLabel("No. of days: " + days);
                daysLabel.setFont(new Font("Georgia", Font.BOLD, 16));
                daysLabel.setBounds(50, 100, 200, 30);
                priceFrame.add(daysLabel);

                JLabel singleBedPriceLabel = new JLabel(
                        "Single Bed Room Price: " + rs.getFloat("single_bed_price") + " * " + noOfSingleBed + " * "
                                + days + " = " + singleBedPrice);
                singleBedPriceLabel.setFont(new Font("Georgia", Font.BOLD, 16));
                singleBedPriceLabel.setBounds(50, 150, 400, 30);
                priceFrame.add(singleBedPriceLabel);

                JLabel doubleBedPriceLabel = new JLabel(
                        "Double Bed Room Price: " + rs.getFloat("double_bed_price") + " * " + noOfDoubleBed + " * "
                                + days + " = " + doubleBedPrice);
                doubleBedPriceLabel.setFont(new Font("Georgia", Font.BOLD, 16));
                doubleBedPriceLabel.setBounds(50, 200, 400, 30);
                priceFrame.add(doubleBedPriceLabel);

                if (!ac.isSelected()) {
                    JLabel acLabel = new JLabel("AC Price: 0.0 ");
                    acLabel.setFont(new Font("Georgia", Font.BOLD, 16));
                    acLabel.setBounds(50, 250, 200, 30);
                    priceFrame.add(acLabel);
                } else {
                    JLabel acLabel = new JLabel(
                            "AC Price: " + rs.getFloat("ac_cost") + " * " + days + " = " + acPrice);
                    acLabel.setFont(new Font("Georgia", Font.BOLD, 16));
                    acLabel.setBounds(50, 250, 400, 30);
                    priceFrame.add(acLabel);
                }

                if (!food.isSelected()) {
                    JLabel foodLabel = new JLabel("Food Price: 0.0 ");
                    foodLabel.setFont(new Font("Georgia", Font.BOLD, 16));
                    foodLabel.setBounds(50, 300, 200, 30);
                    priceFrame.add(foodLabel);
                } else {
                    JLabel foodLabel = new JLabel(
                            "Food Price: " + rs.getFloat("food_cost") + " * " + days + " = " + foodPrice);
                    foodLabel.setFont(new Font("Georgia", Font.BOLD, 16));
                    foodLabel.setBounds(50, 300, 400, 30);
                    priceFrame.add(foodLabel);
                }

                JLabel totalPriceLabel = new JLabel(
                        "Total Price: " + (singleBedPrice + doubleBedPrice + acPrice + foodPrice));
                totalPriceLabel.setFont(new Font("Georgia", Font.BOLD, 16));
                totalPriceLabel.setBounds(50, 350, 400, 30);
                priceFrame.add(totalPriceLabel);

                // Add conirm booking button
                JButton confirmBooking = new JButton("Confirm Booking");
                confirmBooking.setFont(new Font("Georgia", Font.BOLD, 16));
                confirmBooking.setBounds(150, 400, 200, 30);
                confirmBooking.setBackground(new Color(32, 178, 170));
                confirmBooking.addActionListener(this);
                {

                    // @Override
                    // public void actionPerformed(ActionEvent e) {
                    // try {
                    // Connectivity conn = new Connectivity();
                    // String query = "INSERT INTO Hotel_Bookings (username, destination, hotel,
                    // check_in_date, check_out_date, single_bed, double_bed, ac, food, total_price)
                    // VALUES ('"
                    // + userName + "', '" + destination + "', '" + selectedHotel + "', '"
                    // + new java.sql.Date(checkInDate.getTimeInMillis()) + "', '"
                    // + new java.sql.Date(checkOutDate.getTimeInMillis()) + "', " + noOfSingleBed +
                    // ", "
                    // + noOfDoubleBed + ", " + ac.isSelected() + ", " + food.isSelected() + ", "
                    // + (singleBedPrice + doubleBedPrice + acPrice + foodPrice) + ")";
                    // conn.s.executeUpdate(query);
                    // JOptionPane.showMessageDialog(priceFrame, "Booking Confirmed");
                    // priceFrame.setVisible(false);
                    // new HomePage(userName);
                    // } catch (SQLException ex) {
                    // ex.printStackTrace();
                    // }
                    // }
                }
                ;

                priceFrame.setVisible(true);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
