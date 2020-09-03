package graphic_interface;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class PanelListObserver{
    private static  Map<String, JComponent> panelList = null;
    private PanelListObserver(){}
    public static void updateList(String newDescription, AbstractPanel component){
        if(panelList == null){
            panelList = new HashMap<String, JComponent>();
        }
        panelList.put(newDescription, component);
    }
    public static JComponent getComponent(String description){
        return panelList.get(description);
    }
}
