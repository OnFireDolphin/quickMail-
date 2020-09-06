package graphic_interface;

import javax.swing.*;
import java.util.List;

public class AbstractPanel extends JPanel {
    protected PanelChangerObserver _panelChanger;
    protected UndoRedo _undoRedo;
    public AbstractPanel(PanelChangerObserver panelChanger, String name, UndoRedo undoRedo){
        _panelChanger = panelChanger;
        _undoRedo = undoRedo;
        PanelListObserver.updateList(name, this);
    }

    public void getGUI(){ }
    public void notiffy(){}
}
