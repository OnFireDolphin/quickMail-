package graphic_interface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JMenuBar implements ActionListener {
    public Menu(){
        CreateGUI();
    }
    public void CreateGUI(){
        this.setVisible(true);
        JMenuItem subjects, sites, personalInfo;
        subjects = new JMenuItem("subjects");
        subjects.addActionListener(this);
        sites = new JMenuItem("links");
        sites.addActionListener(this);
        personalInfo = new JMenuItem("personal info");
        personalInfo.addActionListener(this);
        this.add(subjects);
        this.add(sites);
        this.add(personalInfo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }
}
