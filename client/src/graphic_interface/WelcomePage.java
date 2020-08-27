package graphic_interface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WelcomePage extends JPanel implements ActionListener {
    Container parent;
    private PanelChangerObserver panelChanger;
    public WelcomePage(PanelChangerObserver panelChanger){
        this.panelChanger = panelChanger;
        getGUI();
    }
    public void getGUI() {
        //Create and set up the window.
        // this.setSize(1000,1000);
        GroupLayout gl = new GroupLayout(this);
        this.setLayout(gl);
        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);
        GroupLayout.SequentialGroup hGroup = gl.createSequentialGroup();
        GroupLayout.SequentialGroup vGroup = gl.createSequentialGroup();

        JLabel labelHello = new JLabel("Hello to our application ");
        JLabel labelDescription = new JLabel(" with your registration," +
                "you will be able to receive emails with the latest news");
        JPanel signInPanel = CreateSection("sign in", "If you have an account you can choose this button", Color.GREEN);
        JPanel signUpPanel = CreateSection("sign up", "Other press this button", Color.ORANGE);


        hGroup.addGroup(gl.createParallelGroup()
                .addComponent(labelHello)
                .addComponent(labelDescription)
                .addComponent(signInPanel)
                .addComponent(signUpPanel, GroupLayout.Alignment.CENTER)
        );

        gl.setHorizontalGroup(hGroup);
        vGroup.addGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(labelHello));
        vGroup.addGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(labelDescription));
        vGroup.addGroup(gl.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(signInPanel));
        vGroup.addGroup(gl.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(signUpPanel));

        gl.setVerticalGroup(vGroup);

    }
    private JPanel CreateSection(String buttonText, String labelText, Color color){
        JPanel panel = new JPanel();
        panel.setVisible(true);
        JButton button = new JButton(buttonText);
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
        panelChanger.updatePanel(action.toString());
    }
}
