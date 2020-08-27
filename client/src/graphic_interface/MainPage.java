package graphic_interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainPage extends JFrame {
    private PanelChangerObserver _panelChanger;
    private Map<String, JComponent> _panelMapping;
    static GraphicsDevice device = GraphicsEnvironment
            .getLocalGraphicsEnvironment().getScreenDevices()[0];

    public MainPage(PanelChangerObserver panelChanger){
        super("news emailing");
        _panelChanger = panelChanger;
        _panelChanger.setMainPage(this);
        _panelMapping = new HashMap<String, JComponent>();
        WelcomePage welcomePage = new WelcomePage(panelChanger);
        SignInWindow signInWindow = new SignInWindow();
        _panelMapping.put("welcome", welcomePage);
        _panelMapping.put("sign in", signInWindow);
        createAndShowUi();
        changePanel();
    }
    public void createAndShowUi(){
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        //Display the window.
    }
    public void changePanel(String previousDescription){
        System.out.println(_panelChanger.getPanel());
        _panelMapping.get(previousDescription).setVisible(false);
        this.getContentPane().add(_panelMapping.get(_panelChanger.getPanel()));
    }
    private void changePanel(){
        System.out.println(_panelChanger.getPanel());
        this.getContentPane().add(_panelMapping.get(_panelChanger.getPanel()));
    }

}
