import graphic_interface.*;
import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PanelChangerObserver panelChanger = new PanelChangerObserver();
                MainPage _mainPage = new MainPage(panelChanger);
            }
        });
    }
}
