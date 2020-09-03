package graphic_interface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JMenuBar implements ActionListener {
    final UndoRedo _undoRedo;
    private JButton back, previous;
    public Menu(UndoRedo undoRedo){
        _undoRedo = undoRedo;
        CreateGUI();

    }
    public void CreateGUI(){
        this.setVisible(true);
        JButton subjects, sites, personalInfo, back, previous;
        subjects = new JButton("subjects");
        subjects.addActionListener(this);
        sites = new JButton("links");
        sites.addActionListener(this);
        personalInfo = new JButton("personal info");
        personalInfo.addActionListener(this);
        this.back = new JButton("Back");
        this.back.addActionListener(this);
        this.previous = new JButton("Previous");
        this.previous.addActionListener(this);
        this.add(this.back);
        this.add(this.previous);
        this.add(subjects);
        this.add(sites);
        this.add(personalInfo);
        updateButtons();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if(e.getActionCommand().equals("Back")){
            _undoRedo.back();
        } else if (e.getActionCommand().equals("Previous")){
            _undoRedo.previous();
        }
    }
    public void updateButtons(){
        System.out.println(_undoRedo.getBack().size());
        if(_undoRedo.getBack().size() > 0){
            this.back.setEnabled(true);
        } else if(_undoRedo.getBack().size() <= 0){
            this.back.setEnabled(false);
        }
        if(_undoRedo.getPrevious().size() > 0){
            this.previous.setEnabled(true);
        } else if(_undoRedo.getPrevious().size() <= 0){
            this.previous.setEnabled(false);
        }
        this.revalidate();
        this.repaint();


    }
}
