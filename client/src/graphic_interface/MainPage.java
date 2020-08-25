package graphic_interface;

import javax.swing.*;

public class MainPage {
    private static WelcomePage _welcomePage;
    public MainPage(){
        _welcomePage = new WelcomePage();
    }
    public static void createAndShowUi(){
        JFrame frame = new JFrame("news emailing");
        frame.setSize(500,300);
        frame.getContentPane().add(_welcomePage);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        //Display the window.

    }
}
