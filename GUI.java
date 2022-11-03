import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI implements ActionListener{

    int hr;

    // int arr for BP, ex [120][80];
    int[] bp = new int[2];

    // float arr for latitude/longitude
    float[] gps = new float[3];

    // fingerprint, retina scan, touchpad etc.,
    // timer for keystrokes
    // stride length
    // sleep metrics
    // password

    public GUI() {
        // basic GUI layout
        // initialize our frame/panel
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        
        JButton button = new JButton("Authenticate");
        
        JTextField hr = new JTextField();
        JTextField gps = new JTextField();
        JTextField bp = new JTextField();
        JTextField pw = new JTextField();

        JLabel hrLabel = new JLabel("Heart Rate:");
        JLabel gpsLabel = new JLabel("Latitude/Longitude:");
        JLabel bpLabel = new JLabel("Blood Pressure (Ex: 120/80):");
        JLabel pwLabel = new JLabel("Password:");

        panel.setBorder(BorderFactory.createEmptyBorder(320, 220, 320, 220));
        panel.setLayout(new GridLayout(0, 1));
        //hrLabel.setBounds(250, 250, 20, 20)
        panel.setBackground(Color.LIGHT_GRAY);

        hrLabel.setHorizontalAlignment(0);

        panel.add(hrLabel);
        panel.add(hr);
        panel.add(gpsLabel);
        panel.add(gps);
        panel.add(bpLabel);
        panel.add(bp);
        panel.add(pwLabel);
        panel.add(pw);
        panel.add(button);
        
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("374 Group 4 Program");
        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        
    }
}
