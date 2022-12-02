import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI implements ActionListener{

    // bool arr for metrics, if x amt == true then authentic
    protected boolean[] auth = new boolean[10];

    protected int hr;
    
    // int arr for BP, ex [120][80];
    private String[] bp = new String[2];

    // float arr for latitude/longitude
    private String[] gps = new String[2];

    private String pw = "temp";
    // fingerprint, retina scan, touchpad etc.,
    // timer for keystrokes
    // stride length
    // sleep metrics
    // password

    public GUI() {
        // basic GUI layout
        // initialize our frame/panel
        CardLayout layout = new CardLayout();

        JFrame frame = new JFrame();

        JPanel infoPanel = new JPanel();
        JPanel authPanel = new JPanel();
        JPanel authentic = new JPanel();
        
        JButton button = new JButton("Authenticate");
        
        JTextField hrField = new JTextField();
        JTextField gpsField = new JTextField();
        JTextField bpField = new JTextField();
        JTextField pwField = new JTextField();

        JLabel hrLabel = new JLabel("Heart Rate:");
        JLabel gpsLabel = new JLabel("Latitude/Longitude:");
        JLabel bpLabel = new JLabel("Blood Pressure (Ex: 120/80):");
        JLabel pwLabel = new JLabel("Password:");

        infoPanel.setBorder(BorderFactory.createEmptyBorder(0, 150, 120, 150));
        authPanel.setBorder(BorderFactory.createEmptyBorder(20, 150, 0, 150));

        infoPanel.setLayout(new GridLayout(0, 1));
        authPanel.setLayout(new GridLayout(0,1));
        authentic.setLayout(new GridLayout(0,1));
        //hrLabel.setBounds(250, 250, 20, 20)
        
        authentic.setBackground(Color.RED);
        infoPanel.setBackground(Color.LIGHT_GRAY);
        authPanel.setBackground(Color.CYAN);

        //hrLabel.setHorizontalAlignment(0);

        // action listener to grab vals from textFields.
        button.addActionListener(new ActionListener()
            {
                // just started working on grabbing value from textFields.
                public void actionPerformed(ActionEvent e) {
                    // HR Field
                    hr = Integer.valueOf(hrField.getText());
                    if(hr >= 140 || hr <= 90)
                    {
                        auth[0] = false;
                        System.out.println(auth[0]);
                    }else
                    {
                        auth[0] = true;
                        System.out.println(auth[0]);
                    }
                    // GPS Field
                    gps = gpsField.getText().split("/");
                    double lat = Double.parseDouble(gps[0]);
                    double lng = Double.parseDouble(gps[1]);

                    if(lat != 42.2507 && lng != 83.6241)
                    {
                        auth[1] = false;
                        System.out.println(auth[1]);
                    }else{
                        auth[1] = true;
                        System.out.println(auth[1]);
                    }

                    // BP Field
                    bp = bpField.getText().split("/");
                    int over = Integer.parseInt(bp[0]);
                    int under = Integer.parseInt(bp[1]);
                    if(over != 120 && under != 80)
                    {
                        auth[2] = false;
                        System.out.println(auth[2]);
            
                    }else
                    {
                        auth[2] = true;
                        System.out.println(auth[2]);
                    }
                    // PW FIELD
                    pw = pwField.getText();
                    if(pw != "password")
                    {
                        auth[3] = false;
                        System.out.println(auth[2]);
                    }else
                    {
                        auth[3] = true;
                        System.out.println(auth[2]);
                    }
                }
            }
        );

        infoPanel.add(hrLabel);
        infoPanel.add(hrField);
        infoPanel.add(gpsLabel);
        infoPanel.add(gpsField);
        infoPanel.add(bpLabel);
        infoPanel.add(bpField);
        infoPanel.add(pwLabel);
        infoPanel.add(pwField);
        authPanel.add(button);
        
        frame.add(infoPanel, BorderLayout.NORTH);
        frame.add(authPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("374 Group 4 Program");
        frame.pack();
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {

    }
    
}
