package graphic_interface;

import javax.swing.*;
import java.awt.*;

public class MainPage extends JFrame {
    final PanelChangerObserver _panelChanger;
    final Menu menu;

    public MainPage(PanelChangerObserver panelChanger, UndoRedo undoRedo){
        super("news emailing");
        _panelChanger = panelChanger;
        _panelChanger.setMainPage(this);
        // undoRedo.updateBack("welcome");
        menu = new Menu(undoRedo);
        _panelChanger.setMenu(menu);
        WelcomePage welcomePage = new WelcomePage(panelChanger, undoRedo);
        SignInWindow signInWindow = new SignInWindow(panelChanger, undoRedo);
        createAndShowUi();
        changePanel();
    }
    public void createAndShowUi(){
        this.setPreferredSize(new Dimension(500, 500));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setJMenuBar(menu);
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
        component.setVisible(true);



    }
    private void changePanel(){
        System.out.println(_panelChanger.getPanel());
        JComponent component = PanelListObserver.getComponent(_panelChanger.getPanel());
        this.getContentPane().add(component);
        component.setVisible(true);
    }

}
