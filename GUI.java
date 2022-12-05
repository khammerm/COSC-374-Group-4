import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI implements ActionListener {

    private JFrame frame = new JFrame();

    private JPanel infoPanel = new JPanel();
    private JPanel authPanel = new JPanel();
    private JPanel failPanel = new JPanel();
    // bool arr for metrics, if x amt == true then authentic
    private boolean[] auth = new boolean[6];

    private int hr;

    // int arr for BP, ex [120][80];
    private String[] bp = new String[2];

    // float arr for latitude/longitude
    private String[] gps = new String[2];

    private String pw = "temp";

    private int strideLength;

    private double hoursSleep;
    // fingerprint, retina scan, touchpad etc.,
    // timer for keystrokes
    // stride length
    // sleep metrics
    // password

    public GUI() {
        // basic GUI layout
        // initialize our frame/panel

        // could mess with this for transition
        // CardLayout layout = new CardLayout();

        JButton button = new JButton("Authenticate");

        JTextField hrField = new JTextField();
        JTextField gpsField = new JTextField();
        JTextField bpField = new JTextField();
        JTextField pwField = new JTextField();
        JTextField strideField = new JTextField();
        JTextField sleepField = new JTextField();

        JLabel failLabel = new JLabel("Authentication Failed.");
        failLabel.setFont(new Font("Serif", Font.BOLD, 24));
        failLabel.setAlignmentY(75);

        JLabel authLabel = new JLabel("Authentication Successful.");
        authLabel.setFont(new Font("Serif", Font.BOLD, 24));

        JLabel div = new JLabel("-----------------------------------------");
        JLabel hrLabel = new JLabel("Heart Rate:");
        JLabel gpsLabel = new JLabel("Latitude/Longitude:");
        JLabel bpLabel = new JLabel("Blood Pressure (Ex: 120/80):");
        JLabel pwLabel = new JLabel("Password:");
        JLabel strideLabel = new JLabel("Stride Length:");
        JLabel sleepLabel = new JLabel("Hours of sleep:");

        infoPanel.setBorder(BorderFactory.createEmptyBorder(0, 150, 120, 150));
        authPanel.setBorder(BorderFactory.createEmptyBorder(20, 150, 0, 150));
        failPanel.setBorder(BorderFactory.createEmptyBorder(360, 150, 120, 150));

        infoPanel.setLayout(new GridLayout(0, 1));
        authPanel.setLayout(new GridLayout(0, 1));
        failPanel.setLayout(new GridLayout(0, 1));
        // hrLabel.setBounds(250, 250, 20, 20)
        
        infoPanel.setBackground(Color.LIGHT_GRAY);
        authPanel.setBackground(Color.GREEN);
        failPanel.setBackground(Color.RED);

        // hrLabel.setHorizontalAlignment(0);

        // action listener to grab vals from textFields.
        button.addActionListener(new ActionListener() {
            // just started working on grabbing value from textFields.
            public void actionPerformed(ActionEvent e) {
                // HR Field
                hr = Integer.valueOf(hrField.getText());
                if (hr >= 140 || hr <= 90) {
                    auth[0] = false;
                } else {
                    auth[0] = true;
                }
                // GPS Field
                gps = gpsField.getText().split("/");
                double lat = Double.parseDouble(gps[0]);
                double lng = Double.parseDouble(gps[1]);

                if (lat != 42.2507 && lng != 83.6241) {
                    auth[1] = false;

                } else {
                    auth[1] = true;

                }

                // BP Field
                bp = bpField.getText().split("/");
                int over = Integer.parseInt(bp[0]);
                int under = Integer.parseInt(bp[1]);
                if (over != 120 && under != 80) {
                    auth[2] = false;

                } else {
                    auth[2] = true;

                }
                // PW FIELD
                pw = pwField.getText();
                if (!pw.equalsIgnoreCase("password")) {
                    auth[3] = false;
                } else {
                    auth[3] = true;
                }
                // stride length
                strideLength = Integer.valueOf(strideField.getText());
                if (strideLength != 2) {
                    auth[4] = false;

                } else {
                    auth[4] = true;

                }
                // sleep metrics
                hoursSleep = Double.valueOf(sleepField.getText());
                if (hoursSleep != 7.8) {
                    auth[5] = false;

                } else {
                    auth[5] = true;

                }
                // frame transitions
                int count = 0;
                if (auth[0] == false) {
                    System.out.println("pw incorrect");
                    frame.remove(infoPanel);
                    frame.add(failPanel, BorderLayout.NORTH);
                    frame.validate();
                }
                for (int i = 0; i < auth.length; i++) {
                    if (auth[i] == true) {
                        count++;
                    }
                }
                if (count > 4)
                {
                    System.out.println("count>4");
                    frame.remove(infoPanel);
                    frame.add(authPanel);
                    frame.validate();
                }else{
                    System.out.println("not verified");
                    frame.remove(infoPanel);
                    frame.add(failPanel, BorderLayout.NORTH);
                    frame.validate();
                }
            }
            // 42.2507/83.6241
        });
        // info panel fields
        infoPanel.add(pwLabel);
        infoPanel.add(pwField);
        infoPanel.add(hrLabel);
        infoPanel.add(hrField);
        infoPanel.add(gpsLabel);
        infoPanel.add(gpsField);
        infoPanel.add(bpLabel);
        infoPanel.add(bpField);
        infoPanel.add(strideLabel);
        infoPanel.add(strideField);
        infoPanel.add(sleepLabel);
        infoPanel.add(sleepField);
        infoPanel.add(div);
        infoPanel.add(button);

        // fail panel fields
        failPanel.add(failLabel);

        // authentic panel fields
        authPanel.add(authLabel);

        frame.add(infoPanel, BorderLayout.NORTH);
        // frame.add(authPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("374 Group 4 Program");
        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

    }

}
