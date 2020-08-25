package graphic_interface;
import javax.swing.*;
import java.awt.*;

public class WelcomePage {
    public WelcomePage(){

    }
    public static JPanel createAndShowGUI() {
        //Create and set up the window.

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(300,300));

        //Add the ubiquitous "Hello World" label.
        JLabel label = new JLabel("Hello World");
        label.setVisible(true);
        panel.setVisible(true);
        JButton button = new JButton("OK");
        panel.add(label,0);
        panel.add(button,0);
        // layer.add(button);
        // layer.add(label);
        return panel;

    }
}
