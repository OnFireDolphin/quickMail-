package graphic_interface;

import javax.swing.*;

public class AbstractPanel extends JPanel {
    protected PanelChangerObserver _panelChanger;
    protected UndoRedo _undoRedo;
    public AbstractPanel(PanelChangerObserver panelChanger, String name, UndoRedo undoRedo){
        _panelChanger = panelChanger;
        _undoRedo = undoRedo;
        getGUI();
        PanelListObserver.updateList(name, this);

    }
    public void getGUI(){ }
}
