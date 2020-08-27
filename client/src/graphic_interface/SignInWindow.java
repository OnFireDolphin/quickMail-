
package graphic_interface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignInWindow extends JPanel implements ActionListener {
    public SignInWindow(){
        this.setVisible(true);
        GetGUI();
    }

    public void GetGUI(){
        JTextField textField = new JTextField(20);
        this.add(textField);
    }

    private JPanel createSection(String labelText){
        JPanel panel = new JPanel();
        JLabel label = new JLabel(labelText);
        return panel;

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
