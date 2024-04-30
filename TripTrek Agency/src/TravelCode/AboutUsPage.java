import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AboutUsPage {
    AboutUsPage() {
        JFrame f = new JFrame("About Us");
        f.setBounds(0, 0, 700, 800);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setAlwaysOnTop(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);

        // Background Image
        ImageIcon background_image = new ImageIcon(ClassLoader.getSystemResource("Icons/aboutUsPage.png"));
        Image img = background_image.getImage().getScaledInstance(700, 700, Image.SCALE_SMOOTH);
        ImageIcon img2 = new ImageIcon(img);
        JLabel background = new JLabel(img2);
        background.setBounds(0, 0, 700, 700);
        f.add(background);

        // Heading
        JLabel heading = new JLabel("About Us");
        heading.setBounds(800, 50, 400, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 30));
        heading.setForeground(Color.WHITE);
        background.add(heading);

        // Ok Button
        JButton back = new JButton("Okay!");
        back.setBounds(320, 560, 100, 30);
        back.setFont(new Font("Georgia", Font.BOLD, 14));
        back.setBackground(new Color(32, 178, 170));
        back.setForeground(Color.BLACK);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
            }
        });
        background.add(back);

        f.setVisible(true);
    }

    public static void main(String[] args) {
        new AboutUsPage();
    }
}