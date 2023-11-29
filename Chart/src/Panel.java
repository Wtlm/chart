import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.lang.*;
import java.util.*;
import java.io.*;


public class Panel extends JPanel{
    public Intro intro;
    public Panel() {
        this.setFocusable(true);
        intro = new Intro(this);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        intro.draw(g);
    }
    
}
