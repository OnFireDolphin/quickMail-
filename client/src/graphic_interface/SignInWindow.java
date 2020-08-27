
package graphic_interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignInWindow extends JPanel implements ActionListener {
    public SignInWindow(){
        this.setVisible(true);
        GetGUI();
        PanelListObserver.updateList("sign in", this);
    }

    public void GetGUI(){
        GroupLayout gl = new GroupLayout(this);
        this.setLayout(gl);
        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);
        GroupLayout.SequentialGroup hGroup = gl.createSequentialGroup();
        GroupLayout.SequentialGroup vGroup = gl.createSequentialGroup();

        JPanel emailPanel = createSection("Enter your email");
        JPanel passwordPanel = createSection("Enter your password");
        JButton signIn = new JButton("Sign in");
        signIn.setPreferredSize(new Dimension(500,20));
        hGroup.addGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(emailPanel,0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(passwordPanel, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(signIn, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        gl.setHorizontalGroup(hGroup);
        vGroup.addGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(emailPanel,0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        vGroup.addGroup(gl.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(passwordPanel, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        vGroup.addGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(signIn, 0, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        gl.setVerticalGroup(vGroup);
    }

    private JPanel createSection(String labelText){
        JPanel panel = new JPanel();
        JLabel label = new JLabel(labelText);
        JTextField textField;
        if(labelText.contains("password")){
            textField = new JPasswordField(50);
        }
        else{
            textField = new JTextField(50);
        }
        panel.add(label);
        panel.add(textField);
        return panel;

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
