/*  Class: COSC 374
 *  ---------------
 *  Group 4 Members:
 *  Kevin Hammermeister
 *  Tyler Begg
 *  Chad Hollens
 *  John Zielinski
 *  ---------------
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI implements ActionListener{

    int hr;

    // int arr for BP, ex [120][80];
    int[] bp = new int[2];

    // float arr for latitude/longitude
    float[] gps = new float[3];


    public GUI() {

        // basic GUI layout
        // initialize our frame/panel
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JButton button = new JButton("Authenticate");
        JTextField hr = new JTextField();

        


        panel.setBorder(BorderFactory.createEmptyBorder(320, 220, 320, 220));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(hr);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("374 Group 4 Program");
        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        
    }
}
