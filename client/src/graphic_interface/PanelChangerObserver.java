package graphic_interface;

import utils.FileManipulation;

import java.io.FileNotFoundException;

public class PanelChangerObserver implements Observer {
    private String _panelDescription;
    private MainPage _mainPage;
    private Menu _menu;
    public PanelChangerObserver(){
        try{
            FileManipulation.getCurrentClient("example.txt");
        } catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        _panelDescription = "welcome";
    }

    @Override
    public void update(String newDescription){
        String previousDescription = new String(_panelDescription);
        _panelDescription = newDescription;
        notifyMainPage(previousDescription);
        notifyMenu();
    }
    public String getPanel(){
        return _panelDescription;
    }
    public void setMainPage(MainPage mainPage){
        _mainPage = mainPage;
    }
    public void setMenu(Menu menu){ _menu = menu;}
    private void notifyMainPage(String previousDescription){
        _mainPage.changePanel(previousDescription);
    }
    private void notifyMenu() { _menu.updateButtons();}
}
