
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Arrays;

public class Login extends JFrame implements ActionListener {
    JLabel welcome, userName, password;
    JTextField userField;
    JPasswordField passwordField;
    JButton loginBt, signupBt, clearBt, forgotBt;

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
        loginBt = new JButton("Login");
        loginBt.setFont(new Font("Georgia", Font.PLAIN, 20));
        loginBt.setForeground(Color.BLACK);
        loginBt.setBackground(Color.white);
        loginBt.setBounds(520, 340, 100, 30);
        loginBt.addActionListener(this);
        add(loginBt);

        // Clear button
        clearBt = new JButton("Clear");
        clearBt.setFont(new Font("Georgia", Font.PLAIN, 20));
        clearBt.setForeground(Color.BLACK);
        clearBt.setBackground(Color.white);
        clearBt.setBounds(670, 340, 100, 30);
        clearBt.addActionListener(this);
        add(clearBt);

        // SignUp button
        signupBt = new JButton("Sign Up");
        signupBt.setFont(new Font("Georgia", Font.PLAIN, 20));
        signupBt.setForeground(Color.BLACK);
        signupBt.setBackground(Color.white);
        signupBt.setBounds(511, 390, 265, 30);
        signupBt.addActionListener(this);
        add(signupBt);

        // Add forgot password button
        forgotBt = new JButton("Forgot Password?");
        forgotBt.setFont(new Font("Georgia", Font.PLAIN, 20));
        forgotBt.setForeground(Color.BLACK);
        forgotBt.setBackground(Color.white);
        forgotBt.setBounds(511, 440, 265, 30);
        forgotBt.addActionListener(this);
        add(forgotBt);

        // Add background
        ImageIcon bgImgIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/LoginBg.gif"));
        JLabel bgLabel = new JLabel(bgImgIcon);
        bgLabel.setBounds(0, 0, 1280, 720);
        add(bgLabel);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == loginBt) {
                try {
                    Connectivity c = new Connectivity();

                    // Check if username and password matches
                    String query = "SELECT * FROM Account WHERE username = '" + userField.getText() + "' ";
                    ResultSet checkUser = c.s.executeQuery(query);

                    if (checkUser.next()) {
                        String storedPassword = checkUser.getString("password");
                        char[] enteredPasswordChars = passwordField.getPassword();
                        String enteredPassword = new String(enteredPasswordChars);
                        if (storedPassword.equals(enteredPassword)) {
                            this.setVisible(false);
                            // Get user's name
                            String name = checkUser.getString("name");

                            // Open the homepage
                            new HomePage(name);

                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid Password", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                        Arrays.fill(enteredPasswordChars, ' ');
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Username");
                    }

                } catch (Exception E) {
                    System.out.println("ERROR: " + E.getMessage());
                }

            } else if (e.getSource() == clearBt) {
                userField.setText("");
                passwordField.setText("");

            } else if (e.getSource() == forgotBt) {
                this.setVisible(false);
                new ForgotPw();
            } else {
                this.setVisible(false);
                new Signup();

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
