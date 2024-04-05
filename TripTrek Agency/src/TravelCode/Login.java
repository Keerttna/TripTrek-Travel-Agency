
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JLabel welcome, userName, password;
    JTextField userField;
    JPasswordField passwordField;
    JButton login, signup, clear;

    Login() {

        setTitle("TripTrek Agency");
        setLayout(null);
        setSize(1280, 720);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Welcome msg
        welcome = new JLabel("Welcome to the TripTrek");
        welcome.setForeground(Color.BLACK);
        welcome.setFont(new Font("Georgia", Font.BOLD, 30));
        welcome.setBounds(450, 30, 450, 40);
        add(welcome);

        // userName
        userName = new JLabel("Username:");
        userName.setFont(new Font("Georgia", Font.BOLD, 20));
        userName.setForeground(Color.BLACK);
        userName.setBounds(450, 200, 375, 30);
        add(userName);

        userField = new JTextField(15);
        userField.setBounds(580, 200, 230, 30);
        userField.setFont(new Font("Georgia", Font.PLAIN, 20));
        add(userField);

        // password
        password = new JLabel("Password:");
        password.setFont(new Font("Georgia", Font.BOLD, 20));
        password.setForeground(Color.BLACK);
        password.setBounds(450, 270, 375, 30);
        add(password);

        passwordField = new JPasswordField(15);
        passwordField.setBounds(580, 270, 230, 30);
        passwordField.setFont(new Font("Georgia", Font.PLAIN, 20));
        add(passwordField);

        // Login button
        login = new JButton("Login");
        login.setFont(new Font("Georgia", Font.PLAIN, 20));
        login.setForeground(Color.BLACK);
        login.setBackground(Color.white);
        login.setBounds(520, 340, 100, 30);
        login.addActionListener(this);
        add(login);

        // Clear button
        clear = new JButton("Clear");
        clear.setFont(new Font("Georgia", Font.PLAIN, 20));
        clear.setForeground(Color.BLACK);
        clear.setBackground(Color.white);
        clear.setBounds(670, 340, 100, 30);
        clear.addActionListener(this);
        add(clear);

        // SignUp button
        signup = new JButton("Sign Up");
        signup.setFont(new Font("Georgia", Font.PLAIN, 20));
        signup.setForeground(Color.BLACK);
        signup.setBackground(Color.white);
        signup.setBounds(511, 390, 265, 30);
        signup.addActionListener(this);
        add(signup);

        // Add background
        ImageIcon bgImgIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/LoginBg.gif"));
        JLabel bgLabel = new JLabel(bgImgIcon);
        // bgLabel.setBounds(getBounds());
        bgLabel.setBounds(0, 0, 1280, 720);

        add(bgLabel);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == login) {

            } else if (e.getSource() == clear) {
                userField.setText("");
                passwordField.setText("");

            } else {
                // new SignUp();
                // setVisible(false);
            }

        } catch (Exception E) {
            System.out.println("ERROR: " + E.getMessage());
        }

    }

    public static void main(String[] args) {
        // LoginTest loginPage =
        new Login();

    }

}
