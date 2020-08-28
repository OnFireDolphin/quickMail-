package graphic_interface;

import javax.swing.*;
import java.awt.*;

public class MainPage extends JFrame {
    private PanelChangerObserver _panelChanger;
    Menu menu;
    static GraphicsDevice device = GraphicsEnvironment
            .getLocalGraphicsEnvironment().getScreenDevices()[0];

    public MainPage(PanelChangerObserver panelChanger){
        super("news emailing");
        _panelChanger = panelChanger;
        _panelChanger.setMainPage(this);
        menu = new Menu();
        WelcomePage welcomePage = new WelcomePage(panelChanger);
        SignInWindow signInWindow = new SignInWindow();
        createAndShowUi();
        changePanel();
    }
    public void createAndShowUi(){
        this.setPreferredSize(new Dimension(500, 500));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        //Display the window.
    }
    public void changePanel(String previousDescription){
        System.out.println(_panelChanger.getPanel());
        PanelListObserver.getComponent(previousDescription).setVisible(false);
        JComponent component = PanelListObserver.getComponent(_panelChanger.getPanel());
        this.getContentPane().add(component);
    }
    private void changePanel(){
        System.out.println(_panelChanger.getPanel());
        JComponent component = PanelListObserver.getComponent(_panelChanger.getPanel());
        this.getContentPane().add(component);
    }

}
