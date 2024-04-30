import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import javax.swing.border.*;

public class Signup extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField nameField;
    private JTextField usernameField;
    private JTextField passwordField;
    private JComboBox<String> securityQuestions;
    private JTextField securityAnsField;
    private JButton createBt, backBt;

    public Signup() {
        setBounds(600, 250, 700, 406);
        setTitle("TripTrek Agency");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel nameLabel = new JLabel("Name :");
        nameLabel.setForeground(Color.DARK_GRAY);
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        nameLabel.setBounds(99, 86, 92, 26);
        contentPane.add(nameLabel);

        JLabel userLabel = new JLabel("Username :");
        userLabel.setForeground(Color.DARK_GRAY);
        userLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        userLabel.setBounds(99, 123, 92, 26);
        contentPane.add(userLabel);

        JLabel passwordLabel = new JLabel("Password :");
        passwordLabel.setForeground(Color.DARK_GRAY);
        passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        passwordLabel.setBounds(99, 160, 92, 26);
        contentPane.add(passwordLabel);

        JLabel securityQuestionLabel = new JLabel("Security Question :");
        securityQuestionLabel.setForeground(Color.DARK_GRAY);
        securityQuestionLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        securityQuestionLabel.setBounds(99, 197, 140, 26);
        contentPane.add(securityQuestionLabel);

        JLabel answerLabel = new JLabel("Answer :");
        answerLabel.setForeground(Color.DARK_GRAY);
        answerLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        answerLabel.setBounds(99, 234, 92, 26);
        contentPane.add(answerLabel);

        ImageIcon signUpIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/signUpIcon.png"));
        Image signUpImg = signUpIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon img = new ImageIcon(signUpImg);

        JLabel imgLabel = new JLabel(img);
        imgLabel.setBounds(460, 70, 200, 200);
        add(imgLabel);

        nameField = new JTextField();
        nameField.setBounds(265, 91, 170, 20);
        contentPane.add(nameField);
        nameField.setColumns(10);

        usernameField = new JTextField();
        usernameField.setColumns(10);
        usernameField.setBounds(265, 128, 170, 20);
        contentPane.add(usernameField);

        passwordField = new JPasswordField();
        passwordField.setColumns(10);
        passwordField.setBounds(265, 165, 170, 20);
        contentPane.add(passwordField);

        // Add a dropdown menu for security questions
        String[] questions = { "What is your pet name?", "What is your lucky number?",
                "What is your favorite book?" };
        securityQuestions = new JComboBox<>(questions);
        securityQuestions.setBounds(265, 202, 170, 20);
        contentPane.add(securityQuestions);

        securityAnsField = new JTextField();
        securityAnsField.setColumns(10);
        securityAnsField.setBounds(265, 239, 170, 20);
        contentPane.add(securityAnsField);

        createBt = new JButton("Create");
        createBt.addActionListener(this);
        createBt.setFont(new Font("Tahoma", Font.BOLD, 13));
        createBt.setBounds(300, 289, 100, 30);
        createBt.setBackground(Color.BLACK);
        createBt.setForeground(Color.WHITE);
        contentPane.add(createBt);

        backBt = new JButton("Back");
        backBt.addActionListener(this);
        backBt.setFont(new Font("Tahoma", Font.BOLD, 13));
        backBt.setBounds(140, 289, 100, 30);
        backBt.setBackground(Color.BLACK);
        backBt.setForeground(Color.WHITE);
        contentPane.add(backBt);

        JPanel panel = new JPanel();
        panel.setForeground(new Color(34, 139, 34));
        panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 2), "Create new Account",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
        panel.setBounds(31, 30, 640, 310);
        panel.setBackground(Color.WHITE);
        contentPane.add(panel);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createBt) {
            String name = nameField.getText();
            String username = usernameField.getText();
            String password = passwordField.getText();
            String selectedQuestion = (String) securityQuestions.getSelectedItem();
            String securityAns = securityAnsField.getText();

            if (name.equals("") || username.equals("") || password.equals("") || securityAns.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill all the fields");
                return;
            } else if (username.length() != 8) {
                JOptionPane.showMessageDialog(null, "Username must be 6 characters long");
                return;
            } else if (password.length() != 4) {
                JOptionPane.showMessageDialog(null, "Password must be 4 characters long");
                return;
            } else if (password.contains(" ")) {
                JOptionPane.showMessageDialog(null, "Password should not contain spaces!");
                return;
            }

            // Insert the new user into the database
            try {
                Connectivity c = new Connectivity();

                // Check if the username already exists
                String check = "select * from Account where username = '" + username + "'";
                c.s.executeQuery(check);
                if (c.s.getResultSet().next()) {
                    JOptionPane.showMessageDialog(null, "Username already exists!");
                    return;
                } else {
                    String q = "insert into Account values('" + name + "','" + username + "','" + password + "','"
                            + selectedQuestion + "','" + securityAns + "')";

                    c.s.executeUpdate(q);

                    // Insert Customer_Details tables with null values for the username and name
                    String q2 = "insert into Customer_Details values('" + username + "','" + name
                            + "',null,null,null,null,null,null)";
                    c.s.executeUpdate(q2);

                    JOptionPane.showMessageDialog(null, "Account Created Successfully!");

                    this.setVisible(false);
                    new Login();
                }

            } catch (Exception E) {
                System.out.println("ERROR: " + E.getMessage());
            }

        } else if (e.getSource() == backBt) {
            this.setVisible(false);
            new Login();
        }

    }

    public static void main(String[] args) {
        new Signup();
    }
}