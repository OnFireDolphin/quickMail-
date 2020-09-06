
package graphic_interface;

import constants.Constants;
import database_manager.signInCheck;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignInWindow extends AbstractPanel implements ActionListener {
    private JTextField password , email;
    private  JLabel errorMessage;

    public SignInWindow(PanelChangerObserver panelChanger, UndoRedo undoRedo){
        super(panelChanger, Constants.SIGN_IN_PAGE, undoRedo);
        email = new JTextField(37);
        password = new JPasswordField(35);
        getGUI();

    }
    @Override
    public void getGUI(){
        GroupLayout gl = new GroupLayout(this);
        this.setLayout(gl);
        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);
        GroupLayout.SequentialGroup hGroup = gl.createSequentialGroup();
        GroupLayout.SequentialGroup vGroup = gl.createSequentialGroup();

        errorMessage = new JLabel("");
        errorMessage.setForeground(Color.RED);
        JButton welcomePage = new JButton(Constants.WELCOME_PAGE);
        welcomePage.addActionListener(this);
        JPanel emailPanel = createSection(Constants.ENTER_EMAIL, email);
        JPanel passwordPanel = createSection(Constants.ENTER_PASSWORD, password);
        JButton signIn = new JButton(Constants.SIGN_IN_BANNER);
        signIn.setPreferredSize(new Dimension(300,20));
        signIn.addActionListener(signIn());
        hGroup.addGroup(gl.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(emailPanel,0, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(passwordPanel, 0, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(signIn, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(errorMessage, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        gl.setHorizontalGroup(hGroup);
        vGroup.addComponent(emailPanel,0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
        vGroup.addGroup(gl.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(passwordPanel, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        vGroup.addGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(signIn, 0, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        vGroup.addGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(errorMessage, 0, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        gl.setVerticalGroup(vGroup);
    }

    private JPanel createSection(String labelText, JTextField textField){
        JPanel panel = new JPanel();
        JLabel label = new JLabel(labelText);
        panel.add(label);
        panel.add(textField);
        return panel;

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        _undoRedo.updateBack(_panelChanger.getPanel());
        _panelChanger.update(e.getActionCommand());
    }

    private ActionListener signIn(){
        ActionListener signIn = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean value = signInCheck.check(email.getText(), password.getText());
                if(value){
                    errorMessage.setText("");
                    System.out.println("ok");
                } else{
                    System.out.println("Your username or your password is incorrect");
                    errorMessage.setText("Your username or your password is incorrect");
                }
            }
        };
        return signIn;
    }
}
