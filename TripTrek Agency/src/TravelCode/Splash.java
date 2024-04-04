import javax.swing.*;

public class Splash extends JFrame implements Runnable {
    Thread t;

    Splash() {

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Icons/opening.gif"));
        JLabel lbl = new JLabel(img, JLabel.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        add(lbl);

        setVisible(true);

        t = new Thread(this);
        t.start();

    }

    public static void main(String[] args) {
        new Splash();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(4100);
            this.setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
