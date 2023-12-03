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
    JButton startButton;
    private boolean start;

    public Intro(Panel panel) {
        this.panel = panel;
        startButton.addMouseListener(mouseHandler);
        start = false;
        try {
            bgr = ImageIO.read(new File("D:/DSA/chart/Data/Cover.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void draw(Graphics g) {
        g.drawImage(bgr, 0, 0, 1200, 600, null);
        DisplayIntro(panel);
    }

    public void DisplayIntro(Panel panel) {
        ImageIcon icon = new ImageIcon("D:/DSA/chart/Data/Cover.gif");
        JButton startButton = new JButton("Let Start!");
        startButton.setFont(new Font("Quicksand", Font.PLAIN, 16));
        startButton.setForeground(Color.white);
        startButton.setBounds(280, 350, 100, 40);
        startButton.setBackground(Color.decode("#7806A6"));
        panel.add(startButton);

        JButton button1 = new JButton(icon);
        button1.setBounds(650, 50, 490, 490);
        panel.add(button1);
    }

}
