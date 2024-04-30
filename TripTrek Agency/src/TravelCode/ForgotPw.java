import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;

import java.awt.event.*;

public class ForgotPw extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField nameField;
    private JTextField usernameField;
    private JComboBox<String> securityQuestions;
    private JTextField securityAnsField;
    private JButton submitBt, backBt;

    public ForgotPw() {

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

        JLabel securityQuestionLabel = new JLabel("Security Question :");
        securityQuestionLabel.setForeground(Color.DARK_GRAY);
        securityQuestionLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        securityQuestionLabel.setBounds(99, 160, 150, 26);
        contentPane.add(securityQuestionLabel);

        JLabel answerLabel = new JLabel("Answer :");
        answerLabel.setForeground(Color.DARK_GRAY);
        answerLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        answerLabel.setBounds(99, 197, 92, 26);
        contentPane.add(answerLabel);

        ImageIcon signUpIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/forgotPwIcon.png"));
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

        // Add a dropdown menu for security questions
        String[] questions = { "What is your pet name?", "What is your lucky number?",
                "What is your favorite book?" };
        securityQuestions = new JComboBox<>(questions);
        securityQuestions.setBounds(265, 165, 170, 20);
        contentPane.add(securityQuestions);

        securityAnsField = new JTextField();
        securityAnsField.setColumns(10);
        securityAnsField.setBounds(265, 204, 170, 20);
        contentPane.add(securityAnsField);

        submitBt = new JButton("Submit");
        submitBt.addActionListener(this);
        submitBt.setFont(new Font("Tahoma", Font.BOLD, 13));
        submitBt.setBounds(300, 259, 100, 30);
        submitBt.setBackground(Color.BLACK);
        submitBt.setForeground(Color.WHITE);
        contentPane.add(submitBt);

        backBt = new JButton("Back");
        backBt.addActionListener(this);
        backBt.setFont(new Font("Tahoma", Font.BOLD, 13));
        backBt.setBounds(140, 259, 100, 30);
        backBt.setBackground(Color.BLACK);
        backBt.setForeground(Color.WHITE);
        contentPane.add(backBt);

        JPanel panel = new JPanel();
        panel.setForeground(new Color(34, 139, 34));
        panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 2), "Forgot Password?",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
        panel.setBounds(31, 30, 640, 310);
        panel.setBackground(Color.WHITE);
        contentPane.add(panel);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent E) {
        if (E.getSource() == submitBt) {
            String name = nameField.getText();
            String username = usernameField.getText();
            String selectedQuestion = (String) securityQuestions.getSelectedItem();
            String enteredAns = securityAnsField.getText();

            if (name.equals("") || username.equals("") || enteredAns.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill all the fields");
                return;
            }

            // Insert the new user into the database
            try {
                Connectivity c = new Connectivity();

                // Check if username and password matches
                String query = "SELECT * FROM Account WHERE username = '" + username + "' ";
                ResultSet checkUser = c.s.executeQuery(query);

                if (checkUser.next()) {
                    String storedQuestion = checkUser.getString("security_question");
                    String storedAns = checkUser.getString("security_answer");
                    if (selectedQuestion.equals(storedQuestion) && enteredAns.equals(storedAns)) {
                        this.setVisible(false);
                        String updatePw = JOptionPane.showInputDialog("Enter new password");

                        // Update the password
                        String updateQuery = "UPDATE Account SET password = '" + updatePw + "' WHERE username = '"
                                + username + "'";
                        c.s.executeUpdate(updateQuery);

                        JOptionPane.showMessageDialog(null, "Password Update Successful");

                        new Login();
                    } else {
                        JOptionPane.showMessageDialog(null, "Wrong answer!", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username");
                }

            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
            }

        } else if (E.getSource() == backBt) {
            this.setVisible(false);
            new Login();
        }

    }

    public static void main(String[] args) {
        new ForgotPw();
    }

}
