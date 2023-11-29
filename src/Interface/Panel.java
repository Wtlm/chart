package Interface;

import java.awt.*;
import javax.swing.*;

import Stages.Intro;
import Stages.Option;

public class Panel extends JPanel {

    public Intro intro;
    public Option option;

    public Panel() {
        this.setFocusable(true);
        intro = new Intro(this);
        // option = new Option(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        intro.draw(g);
    }

}
