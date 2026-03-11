import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClock extends JFrame implements Runnable {

    JLabel clockLabel;
    Thread t;

    DigitalClock() {

        setTitle("Digital Clock");
        setSize(350,150);
        setLayout(new FlowLayout());

        clockLabel = new JLabel();
        clockLabel.setFont(new Font("Arial", Font.BOLD, 40));

        add(clockLabel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        t = new Thread(this);
        t.start();
    }

    public void run() {

        while(true) {

            Date d = new Date();

            SimpleDateFormat sdf = new SimpleDateFormat("HH : mm : ss");

            String time = sdf.format(d);

            clockLabel.setText(time);

            try {
                Thread.sleep(1000);
            }
            catch(Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {

        new DigitalClock();
    }
}