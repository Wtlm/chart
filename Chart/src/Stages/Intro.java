package Stages;
import java.awt.*;

import javax.swing.*;

import Action.MouseHandler;
import Interface.Panel;

import javax.imageio.*;
import java.io.*;

public class Intro {
    public Image bgr;
    MouseHandler mouseHandler;
    Panel panel;
    public Intro(Panel panel) {
        this.panel = panel;
        try {
            bgr = ImageIO.read(new File("D:/DSA/Project/lib/Cover.png"));
            bgr = bgr.getScaledInstance(1000, 500, 2/3);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void draw(Graphics g) {
        g.drawImage(bgr, 0, 0, null);
        DisplayIntro(panel);
    }

    public void DisplayIntro(Panel panel) {
        ImageIcon icon = new ImageIcon("D:/DSA/Project/lib/Cover.gif");
        JButton button = new JButton("Let Start!");
        button.setFont(new Font("SansSerif", Font.BOLD, 15));
        button.setForeground(Color.white);
        button.setBounds(600,380,100,40); 
        button.setBackground(Color.decode("#7806A6"));
        button.addMouseListener(mouseHandler);
        panel.add(button);

        JButton button1 = new JButton(icon);
        button1.setBounds(900,150,490,490); 
        panel.add(button1);
    }
}
