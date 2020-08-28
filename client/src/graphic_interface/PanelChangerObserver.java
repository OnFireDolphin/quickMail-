package graphic_interface;

import utils.FileManipulation;

import java.io.FileNotFoundException;

public class PanelChangerObserver implements Observer {
    private String _panelDescription;
    private MainPage _mainPage;
    public PanelChangerObserver(){
        try{
            FileManipulation.readFile("example.txt");
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
