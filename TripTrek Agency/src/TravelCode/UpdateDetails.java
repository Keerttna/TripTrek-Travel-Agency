import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;
import com.toedter.calendar.JDateChooser;

public class UpdateDetails extends JFrame implements ActionListener {
    private JPanel contentPane;
    JRadioButton male, female;
    ButtonGroup gender;
    String username;
    JTextField nameField, phoneField, emailField, idNoField;
    JDateChooser dobField;
    JComboBox<String> idTypeField;

    UpdateDetails(String usernameFromHotel) {
        username = usernameFromHotel;

        setBounds(600, 250, 700, 406);
        setTitle("TripTrek Agency");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        // Update details icon
        ImageIcon updateIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/updateIcon.png"));
        Image updateImg = updateIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon img = new ImageIcon(updateImg);

        JLabel imgLabel = new JLabel(img);
        imgLabel.setBounds(460, 70, 200, 200);
        contentPane.add(imgLabel);

        // Name label
        JLabel nameLabel = new JLabel("Name :");
        nameLabel.setForeground(Color.BLACK);
        nameLabel.setFont(new Font("Georgia", Font.BOLD, 14));
        nameLabel.setBounds(99, 40, 80, 26);
        contentPane.add(nameLabel);

        // Name field
        nameField = new JTextField();
        nameField.setBounds(230, 40, 200, 26);
        contentPane.add(nameField);

        // Gender label
        JLabel genderLabel = new JLabel("Gender :");
        genderLabel.setForeground(Color.BLACK);
        genderLabel.setFont(new Font("Georgia", Font.BOLD, 14));
        genderLabel.setBounds(99, 77, 80, 26);
        contentPane.add(genderLabel);

        // Radio button
        male = new JRadioButton("Male");
        male.setFont(new Font("Georgia", Font.PLAIN, 14));
        male.setBackground(Color.WHITE);
        male.setBounds(230, 77, 70, 26);
        contentPane.add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Georgia", Font.PLAIN, 14));
        female.setBackground(Color.WHITE);
        female.setBounds(300, 77, 100, 26);
        contentPane.add(female);

        gender = new ButtonGroup();
        gender.add(male);
        gender.add(female);

        // Date of Birth label
        JLabel dobLabel = new JLabel("Date of Birth :");
        dobLabel.setForeground(Color.BLACK);
        dobLabel.setFont(new Font("Georgia", Font.BOLD, 14));
        dobLabel.setBounds(99, 114, 105, 26);
        contentPane.add(dobLabel);

        // Date of Birth field - Minimum 18 years old
        dobField = new JDateChooser();
        dobField.setBounds(230, 114, 200, 26);
        dobField.setMaxSelectableDate(new java.util.Date());
        dobField.setBounds(230, 114, 200, 26);
        dobField.setDateFormatString("dd-MM-yyyy");
        contentPane.add(dobField);

        // Phone no label
        JLabel phoneLabel = new JLabel("Phone No :");
        phoneLabel.setForeground(Color.BLACK);
        phoneLabel.setFont(new Font("Georgia", Font.BOLD, 14));
        phoneLabel.setBounds(99, 151, 80, 26);
        contentPane.add(phoneLabel);

        // Phone no field
        phoneField = new JTextField();
        phoneField.setBounds(230, 151, 200, 26);
        contentPane.add(phoneField);

        // Email label
        JLabel emailLabel = new JLabel("Email :");
        emailLabel.setForeground(Color.BLACK);
        emailLabel.setFont(new Font("Georgia", Font.BOLD, 14));
        emailLabel.setBounds(99, 188, 80, 26);
        contentPane.add(emailLabel);

        // Email field
        emailField = new JTextField();
        emailField.setBounds(230, 188, 200, 26);
        contentPane.add(emailField);

        // ID Type label
        JLabel idTypeLabel = new JLabel("ID Type :");
        idTypeLabel.setForeground(Color.BLACK);
        idTypeLabel.setFont(new Font("Georgia", Font.BOLD, 14));
        idTypeLabel.setBounds(99, 225, 80, 26);
        contentPane.add(idTypeLabel);

        // ID Type field
        idTypeField = new JComboBox<String>();
        idTypeField.setModel(new DefaultComboBoxModel<String>(new String[] { "Passport", "Aadhar Card", "Voter ID" }));
        idTypeField.setBounds(230, 225, 200, 26);
        contentPane.add(idTypeField);

        // ID No label
        JLabel idNoLabel = new JLabel("ID No :");
        idNoLabel.setForeground(Color.BLACK);
        idNoLabel.setFont(new Font("Georgia", Font.BOLD, 14));
        idNoLabel.setBounds(99, 262, 80, 26);
        contentPane.add(idNoLabel);

        // ID No field
        idNoField = new JTextField();
        idNoField.setBounds(230, 262, 200, 26);
        contentPane.add(idNoField);

        // Update button
        JButton updateButton = new JButton("Update");
        updateButton.setBounds(200, 300, 150, 33);
        updateButton.setBackground(new Color(32, 178, 170));
        updateButton.setForeground(Color.BLACK);
        updateButton.setFont(new Font("Georgia", Font.BOLD, 14));
        updateButton.addActionListener(this);

        contentPane.add(updateButton);

        JPanel panel = new JPanel();
        panel.setForeground(new Color(34, 139, 34));
        panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 0), 2), "Update-Details",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
        panel.setBounds(15, 15, 655, 335);
        panel.setBackground(Color.WHITE);
        contentPane.add(panel);

        this.setVisible(true);

    }

    public static void main(String[] args) {
        new UpdateDetails("sai13").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Update the details in the database Customer_Details table
        String name = nameField.getText();
        String gender;
        if (male.isSelected()) {
            gender = "male";
        } else {
            gender = "female";
        }
        String dob = ((JTextField) dobField.getDateEditor().getUiComponent()).getText();
        String phone = phoneField.getText();
        String email = emailField.getText();
        String idType = (String) idTypeField.getSelectedItem();
        String idNo = idNoField.getText();

        if (name.isEmpty() || dob.isEmpty() || phone.isEmpty() || email.isEmpty() || idNo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all the fields!");
        } else if (!male.isSelected() && !female.isSelected()) {
            JOptionPane.showMessageDialog(null, "Please select your gender!");
        } else if (phone.length() != 10) {
            JOptionPane.showMessageDialog(null, "Please enter valid phone no.!");
        } else if (!email.contains("@") || !email.contains(".")) {
            JOptionPane.showMessageDialog(null, "Please enter valid email id!");
        } else if (idType.equals("Passport") && idNo.length() != 8) {
            JOptionPane.showMessageDialog(null, "Please enter valid Passport no.!");
        } else if (idType.equals("Aadhar Card") && idNo.length() != 12) {
            JOptionPane.showMessageDialog(null, "Please enter valid Aadhar Card no.!");
        } else if (idType.equals("Voter ID") && idNo.length() != 10) {
            JOptionPane.showMessageDialog(null, "Please enter valid Voter ID no.!");
        } else {
            try {
                Connectivity conn = new Connectivity();
                // Update the details in the database
                String updateQuery = "UPDATE Customer_Details SET name='" + name + "', gender='" + gender + "', dob='"
                        + dob +
                        "', phone_no='" + phone + "', email_id='" + email + "', id_type='" + idType + "', id_no='"
                        + idNo +
                        "' WHERE username='" + username + "'";
                conn.s.executeUpdate(updateQuery);

                JOptionPane.showMessageDialog(null, "Details Updated Successfully");
                this.setVisible(false);

            } catch (Exception e1) {
                e1.printStackTrace();

            }

        }

    }
}
