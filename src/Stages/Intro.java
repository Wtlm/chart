package Stages;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Action.MouseHandler;
import Interface.Panel;

import javax.imageio.*;
import java.io.*;

public class Intro {
    MouseHandler mouseHandler;
    Panel panel;

    public Image cover;
    public JButton startButton;
    private boolean start = false;

    public Intro(Panel panel) {
        this.panel = panel;
        startButton = new JButton();
        try {
            cover = ImageIO.read(new File("D:/DSA/chart/Data/Cover.png"));
            start();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public boolean getStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public void draw(Graphics g) {
        g.drawImage(cover, 0, 0, 1200, 600, null);
        DisplayIntro(panel);
    }

    public void DisplayIntro(Panel panel) {
        ImageIcon icon = new ImageIcon("D:/DSA/chart/Data/Cover.gif");
        startButton.setText("Let Start!");
        startButton.setFont(new Font("Quicksand", Font.PLAIN, 16));
        startButton.setForeground(Color.white);
        startButton.setBounds(280, 350, 100, 40);
        startButton.setBackground(Color.decode("#7806A6"));
        panel.add(startButton);

        JButton button1 = new JButton(icon);
        button1.setBounds(650, 50, 490, 490);
        panel.add(button1);
    }

    public void start() {
        ActionListener startListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Start");
                setStart(true);
            }
        };
        startButton.addActionListener(startListener);
    }

}
