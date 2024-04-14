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
import java.util.Date;
import java.util.TimeZone;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.toedter.calendar.JDateChooser;

public class HotelsPage extends JFrame implements ActionListener {
    private JPanel contentPane;
    JButton back, checkPriceBt, confirmBooking;
    String name, userName, destination, selectedPackage, selectedPickUp;
    int people, singleBedCount, doubleBedCount, days;
    JComboBox<String> hotelList;
    JDateChooser checkInField;
    JTextField checkOutField;
    ButtonGroup roomTypeGroup, acGroup, foodGroup;
    JRadioButton singleBed, doubleBed, ac, nonAc, food, noFood;
    float acPrice = 0, foodPrice = 0;
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
        JLabel roomType = new JLabel("Room Type : ");
        roomType.setFont(new Font("Georgia", Font.BOLD, 16));
        roomType.setBounds(80, 200, 200, 30);
        panel.add(roomType);

        // Add a radio button for selecting room type
        singleBed = new JRadioButton("Single Bed Room");
        singleBed.setFont(new Font("Georgia", Font.BOLD, 16));
        singleBed.setBounds(120, 240, 200, 30);
        panel.add(singleBed);

        doubleBed = new JRadioButton("Double Bed Room");
        doubleBed.setFont(new Font("Georgia", Font.BOLD, 16));
        doubleBed.setBounds(120, 280, 200, 30);
        panel.add(doubleBed);

        roomTypeGroup = new ButtonGroup();
        roomTypeGroup.add(singleBed);
        roomTypeGroup.add(doubleBed);

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

                // Check if check-in date is selected
                if (checkInField.getDate() == null) {
                    JOptionPane.showMessageDialog(this, "Please select check-in date !", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Check if room type is selected
                if (!singleBed.isSelected() && !doubleBed.isSelected()) {
                    JOptionPane.showMessageDialog(this, "Please select room type !", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Check if ac is selected
                if (!ac.isSelected() && !nonAc.isSelected()) {
                    JOptionPane.showMessageDialog(this, "Please select AC/Non AC !", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Check if food is selected
                if (!food.isSelected() && !noFood.isSelected()) {
                    JOptionPane.showMessageDialog(this, "Please select food !", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Get the selected hotel
                String selectedHotel = hotelList.getSelectedItem().toString();

                Connectivity conn = new Connectivity();
                String query = "SELECT * FROM Hotels_available WHERE hotel = '" + selectedHotel + "' ";
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next() == false) {
                    JOptionPane.showMessageDialog(this, "Hotel not available");
                    return;
                }

                if (singleBed.isSelected()) {
                    singleBedCount = people;
                    doubleBedCount = 0;
                } else if (doubleBed.isSelected()) {
                    singleBedCount = 0;
                    doubleBedCount = people / 2;
                }

                float singleBedPrice = rs.getFloat("single_bed_cost") * singleBedCount * days;
                float doubleBedPrice = rs.getFloat("double_bed_cost") * doubleBedCount * days;

                // Check if ac is selected
                if (ac.isSelected()) {
                    acPrice = rs.getFloat("ac_cost") * days;
                } else {
                    acPrice = 0;
                }

                // Check if food is selected
                if (food.isSelected()) {
                    foodPrice = rs.getFloat("food_cost") * days;
                } else {
                    foodPrice = 0;
                }

                float packagePrice = 0;

                if (selectedPackage.equals("Gold")) {
                    packagePrice = 10000;

                } else if (selectedPackage.equals("Silver")) {
                    packagePrice = 8000;

                } else {
                    packagePrice = 5000;
                }

                float totalPrice = packagePrice + singleBedPrice + doubleBedPrice + acPrice + foodPrice;

                // Display the price in a new frame
                JFrame priceFrame = new JFrame();
                priceFrame.setSize(500, 550);
                priceFrame.setTitle("Confirm booking");
                priceFrame.setLayout(null);
                priceFrame.setLocationRelativeTo(null);
                priceFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);

                JLabel txt = new JLabel("Please confirm the booking details");
                txt.setFont(new Font("Times New Roman", Font.BOLD, 16));
                txt.setBounds(50, 10, 400, 30);
                priceFrame.add(txt);

                JLabel hotelLabel = new JLabel("\u2022  Hotel: " + selectedHotel);
                hotelLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
                ;
                hotelLabel.setBounds(50, 50, 400, 30);
                priceFrame.add(hotelLabel);

                JLabel checkInLabel = new JLabel(
                        "\u2022  Check-in Date: " + SimpleDateFormat.getDateInstance().format(checkInTime));
                checkInLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
                checkInLabel.setBounds(50, 90, 400, 30);
                priceFrame.add(checkInLabel);

                JLabel checkOutLabel = new JLabel(
                        "\u2022  Check-out Date: " + SimpleDateFormat.getDateInstance().format(checkOutTime));
                checkOutLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
                checkOutLabel.setBounds(50, 130, 400, 30);
                priceFrame.add(checkOutLabel);

                JLabel singleBedPriceLabel = new JLabel(
                        "\u2022  Single Bed Room Price: " + singleBedPrice);
                singleBedPriceLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
                singleBedPriceLabel.setBounds(50, 170, 440, 30);
                priceFrame.add(singleBedPriceLabel);

                JLabel doubleBedPriceLabel = new JLabel(
                        "\u2022  Double Bed Room Price: " + doubleBedPrice);
                doubleBedPriceLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
                doubleBedPriceLabel.setBounds(50, 210, 440, 30);
                priceFrame.add(doubleBedPriceLabel);

                if (!ac.isSelected()) {
                    JLabel acLabel = new JLabel("\u2022  AC Price: 0.0 ");
                    acLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
                    acLabel.setBounds(50, 250, 200, 30);
                    priceFrame.add(acLabel);
                } else {
                    JLabel acLabel = new JLabel(
                            "\u2022  AC Price: " + acPrice);
                    acLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
                    acLabel.setBounds(50, 250, 400, 30);
                    priceFrame.add(acLabel);
                }

                if (!food.isSelected()) {
                    JLabel foodLabel = new JLabel("\u2022  Food Price: 0.0 ");
                    foodLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
                    foodLabel.setBounds(50, 290, 200, 30);
                    priceFrame.add(foodLabel);
                } else {
                    JLabel foodLabel = new JLabel("\u2022  Food Price: " + foodPrice);
                    foodLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
                    foodLabel.setBounds(50, 290, 400, 30);
                    priceFrame.add(foodLabel);
                }

                JLabel packageLabel = new JLabel("\u2022  Package Price: " + packagePrice);
                packageLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
                packageLabel.setBounds(50, 330, 400, 30);
                priceFrame.add(packageLabel);

                JLabel totalPriceLabel = new JLabel(
                        "  Total Price: " + totalPrice);
                totalPriceLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
                totalPriceLabel.setBounds(150, 380, 170, 30);
                Border border = new LineBorder(Color.BLACK, 2);
                totalPriceLabel.setBorder(border);

                priceFrame.add(totalPriceLabel);

                // Add back button
                JButton back = new JButton("Back");
                back.setFont(new Font("Times New Roman", Font.BOLD, 16));
                back.setBounds(45, 450, 200, 30);
                back.setBackground(new Color(32, 178, 170));
                back.setForeground(Color.BLACK);
                back.addActionListener((ActionEvent e1) -> {
                    priceFrame.setVisible(false);
                });
                priceFrame.add(back);

                // Add confirm booking button
                JButton confirmBooking = new JButton("Confirm Booking");
                confirmBooking.setFont(new Font("Times New Roman", Font.BOLD, 16));
                confirmBooking.setBounds(270, 450, 200, 30);
                confirmBooking.setBackground(new Color(32, 178, 170));
                confirmBooking.setForeground(Color.BLACK);
                confirmBooking.addActionListener((ActionEvent e1) -> {
                    priceFrame.setVisible(false);
                    JOptionPane.showMessageDialog(this, "Booking confirmed successfully !", "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                });
                priceFrame.add(confirmBooking);

                priceFrame.setVisible(true);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
