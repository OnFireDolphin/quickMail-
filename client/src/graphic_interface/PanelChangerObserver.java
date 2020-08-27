package graphic_interface;

import com.sun.tools.javac.Main;

public class PanelChangerObserver implements Observer {
    private String _panelDescription;
    private MainPage _mainPage;
    public PanelChangerObserver(){
        _panelDescription = new String("welcome");
    }

    @Override
    public void update(String newDescription){
        String previousDescription = new String(_panelDescription);
        _panelDescription = newDescription;
        notifyMainPage(previousDescription);
    }
    public String getPanel(){
        return _panelDescription;
    }
    public void setMainPage(MainPage mainPage){
        _mainPage = mainPage;
    }
    private void notifyMainPage(String previousDescription){
        _mainPage.changePanel(previousDescription);
    }
}
