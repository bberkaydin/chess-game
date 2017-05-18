/**
 * Created by berk on 19.07.2014.
 */
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class Clock extends JFrame  {
    JLabel timerLabel;
    int counter=120;
    JTextField tf;
    JButton button;
    Timer timer;
    public Clock() {
        this.setLayout(new GridLayout(2,1));
        button = new JButton("Start timing");
        this.add(button);
        timerLabel = new JLabel("You have =>120 seconds");
        this.add(timerLabel);
        event e =  new event();
        button.addActionListener(e);
    }
    public class event implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int count = 120;
            TimeClass tc = new TimeClass(count);
            timer = new Timer(1000, tc);
            timer.start();
        }
    }
    public class TimeClass implements ActionListener {
        private int counter;
        public TimeClass(int counter) {
            this.counter= counter;
        }
        public void actionPerformed(ActionEvent tc) {
            counter--;
            if(counter >= 1) {
                timerLabel.setText("You have =>" + counter+"seconds");
            }
            else {
                timerLabel.setText("Time is up.");
            }
        }
    }
    /*public static void main(String args[]) {
        Clock gui = new Clock();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(250, 150);
        gui.setTitle("Clock");
        gui.setVisible(true);
    } */
}
