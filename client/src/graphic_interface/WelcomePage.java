package graphic_interface;
import constants.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage extends AbstractPanel implements ActionListener {
    public WelcomePage(PanelChangerObserver panelChanger, UndoRedo undoRedo){
        super(panelChanger, Constants.WELCOME_PAGE, undoRedo);
        getGUI();
    }
    @Override
    public void getGUI() {
        //Create and set up the window.
        // this.setSize(1000,1000);
        GroupLayout gl = new GroupLayout(this);
        this.setLayout(gl);
        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);
        GroupLayout.SequentialGroup hGroup = gl.createSequentialGroup();
        GroupLayout.SequentialGroup vGroup = gl.createSequentialGroup();

        JLabel labelHello = new JLabel(Constants.WELCOMING);
        JLabel labelDescription = new JLabel(Constants.APP_OBJECTIVE);
        JPanel signInPanel = CreateSection(Constants.SIGN_IN_PAGE, Constants.SIGN_IN_LABEL, Color.GREEN);
        JPanel signUpPanel = CreateSection(Constants.SIGN_UP_PAGE, Constants.SIGN_UP_LABEL, Color.ORANGE);


        hGroup.addGroup(gl.createParallelGroup()
                .addComponent(labelHello)
                .addComponent(labelDescription)
                .addComponent(signInPanel, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(signUpPanel, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        gl.setHorizontalGroup(hGroup);
        vGroup.addGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(labelHello));
        vGroup.addGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(labelDescription));
        vGroup.addGroup(gl.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(signInPanel, 0, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE));
        vGroup.addGroup(gl.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(signUpPanel, 0, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE));

        gl.setVerticalGroup(vGroup);

    }
    private JPanel CreateSection(String buttonText, String labelText, Color color){
        JPanel panel = new JPanel();
        panel.setVisible(true);
        JButton button = new JButton(buttonText);
        button.setPreferredSize(new Dimension(150,50));
        button.addActionListener(this);
        JLabel label = new JLabel(labelText);
        panel.add(label);
        panel.add(button);
        panel.setBackground(color);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        _undoRedo.updateBack(_panelChanger.getPanel());
        _panelChanger.update(action);

    }
}
