package graphic_interface;

import java.util.ArrayList;
import java.util.List;

public class UndoRedo {
    private final List<String> back;
    private final List<String> previous;
    private final PanelChangerObserver _panelChanger;
    public UndoRedo(PanelChangerObserver panelChanger){
        back = new ArrayList<>();
        previous = new ArrayList<>();
        _panelChanger = panelChanger;
    }
    public void updateBack(String newDescription){
        back.add(new String(newDescription));
        previous.clear();
    }
    public void back(){
        previous.add(_panelChanger.getPanel());
        String currentPanel = back.remove(back.size()-1);
        _panelChanger.update(currentPanel);
    }
    public void previous(){
        back.add(_panelChanger.getPanel());
        String panel = previous.remove(previous.size()-1);
        _panelChanger.update(panel);
    }
    public List<String> getBack(){
        return back;
    }
    public List<String> getPrevious(){
        return previous;
    }
}
