package graphic_interface;

import javax.swing.*;

public class MainPage {
    private static WelcomePage _welcomePage;
    public MainPage(){
        _welcomePage = new WelcomePage();
    }
    public static void createAndShowUi(){
        JFrame frame = new JFrame("news emailing");
        frame.getContentPane().add(_welcomePage.createAndShowGUI());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
