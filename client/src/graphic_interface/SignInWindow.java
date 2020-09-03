
package graphic_interface;

import constants.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignInWindow extends AbstractPanel implements ActionListener {
    public SignInWindow(PanelChangerObserver panelChanger, UndoRedo undoRedo){
        super(panelChanger, Constants.SIGN_IN_PAGE, undoRedo);
    }
    @Override
    public void getGUI(){
        GroupLayout gl = new GroupLayout(this);
        this.setLayout(gl);
        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);
        GroupLayout.SequentialGroup hGroup = gl.createSequentialGroup();
        GroupLayout.SequentialGroup vGroup = gl.createSequentialGroup();

        JButton welcomePage = new JButton("welcome");
        welcomePage.addActionListener(this);
        JPanel emailPanel = createSection("Enter your email");
        JPanel passwordPanel = createSection("Enter your password");
        JButton signIn = new JButton("Sign in");
        signIn.setPreferredSize(new Dimension(300,20));
        hGroup.addGroup(gl.createParallelGroup()
                .addComponent(welcomePage)
        );
        hGroup.addGroup(gl.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(emailPanel,0, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(passwordPanel, 0, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(signIn, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        gl.setHorizontalGroup(hGroup);
        vGroup.addGroup(gl.createParallelGroup()
                .addComponent(welcomePage)
        );
        vGroup.addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
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
            textField = new JPasswordField(35);
        }
        else{
            textField = new JTextField(35);
        }
        panel.add(label);
        panel.add(textField);
        return panel;

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        _undoRedo.updateBack(_panelChanger.getPanel());
        _panelChanger.update(e.getActionCommand());
    }
}
