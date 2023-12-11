package Interface;

import java.awt.*;
import javax.swing.*;

import Stages.Intro;
import Stages.Option;
import Support.*;

public class Panel extends JPanel {
    public Intro intro;
    public Option option;
    public Table table;
    public int stage;
    public int introStage = 0;
    public int optionStage = 1;

    public Panel() {
        this.setFocusable(true);
        try {
        // intro = new Intro(this);
        // option = new Option(this); 
        table = new Table(this);
        
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if (stage == introStage){
            // intro.draw(g2);
            table.draw(g2);
        }
        else if (stage == optionStage)
            option.draw(g2);
            repaint();
    }

}
