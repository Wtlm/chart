package Interface;

import java.awt.*;
import javax.swing.*;

import Stages.Intro;
import Stages.Option;

public class Panel extends JPanel {
    public Intro intro;
    public Option option;
    public int stage;
    public int introStage = 0;
    public int optionStage = 1;

    public Panel() {
        this.setFocusable(true);
        intro = new Intro(this);
        option = new Option(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if (stage == introStage)
            intro.draw(g2);
        else if (stage == optionStage)
            option.draw(g2);

    }

}
