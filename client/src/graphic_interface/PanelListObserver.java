package graphic_interface;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class PanelListObserver{
    private static  Map<String, AbstractPanel> panelList = null;
    private PanelListObserver(){}
    public static void updateList(String newDescription, AbstractPanel component){
        if(panelList == null){
            panelList = new HashMap<String, AbstractPanel>();
        }
        panelList.put(newDescription, component);
    }
    public static AbstractPanel getComponent(String description){
        return panelList.get(description);
    }
}
