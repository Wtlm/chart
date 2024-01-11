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
    public ImageIcon icon;
    public JButton startButton;
    JLabel gif;

    public Intro(Panel panel) {
        this.panel = panel;
        startButton = new JButton();
        gif = new JLabel();
        try {
            cover = ImageIO.read(new File("D:/DSA/chart/Data/Cover.png"));
            icon = new ImageIcon("D:/DSA/chart/Data/Cover.gif");
            start(panel);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // button1 = new JButton(icon);
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(cover, 0, 0, 1200, 600, null);
        DisplayIntro(panel);
    }

    public void DisplayIntro(Panel panel) {
        startButton.setText("Let Start!");
        startButton.setFont(new Font("Quicksand", Font.PLAIN, 16));
        startButton.setForeground(Color.white);
        startButton.setBounds(280, 350, 100, 40);
        startButton.setBackground(Color.decode("#7806A6"));
        panel.add(startButton);

        gif.setIcon(icon);
        gif.setBounds(650, 50, 490, 490);
        panel.add(gif);
    }

    public void start(Panel panel) {
        ActionListener startListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Start");
                panel.stage = panel.optionStage;
                panel.removeAll();
            }
        };
        startButton.addActionListener(startListener);
    }

}
