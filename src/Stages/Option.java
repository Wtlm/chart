package Stages;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import java.awt.event.MouseEvent;

import javax.swing.*;


import javax.imageio.ImageIO;
import javax.swing.border.*;

import Action.MouseHandler;
import Interface.Panel;

public class Option {
    Panel panel;
    public BufferedImage bgr, pie1, pie2, bar1, bar2;
    JLabel label;
    private int height;
    public int chooseBar, choosePie;

    public Option(Panel panel) {
        this.panel = panel;
        label = new JLabel();
        chooseBar = 0;
        choosePie = 0;
        height = 600;
        try {

            bgr = ImageIO.read(new File("D:/DSA/chart/Data/BGR.png"));
            pie1 =  ImageIO.read(new File("D:/DSA/chart/Data/pie1.png"));
            pie2 =  ImageIO.read(new File("D:/DSA/chart/Data/pie2.png"));
            bar1 =  ImageIO.read(new File("D:/DSA/chart/Data/bar1.png"));
            bar2 =  ImageIO.read(new File("D:/DSA/chart/Data/bar2.png"));

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void draw(Graphics2D g2) {
        g2.drawImage(bgr, 0, getHeight(), 1200, 600, null);
        if (chooseBar == 0) 
            g2.drawImage(bar1, 700, getHeight() + 100, 400, 400, null);
        else 
            g2.drawImage(bar2, 700, getHeight() + 100, 400, 400, null);

        if (choosePie == 0) 
            g2.drawImage(pie1, 100, getHeight() + 100, 400, 400, null);
        else 
            g2.drawImage(pie2, 100, getHeight() + 100, 400, 400, null);

        addButton(panel);
    }

    public int updateBgr() {
        return height -= 1;

    }

    public void addButton(Panel panel) {
        label.setText("Choose a chart");
        label.setBounds(0, getHeight(), panel.getWidth(), 100);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 40));
        label.setForeground(Color.WHITE);
        panel.add(label);

        // pieButton.setBounds(100, getHeight() + 100, 400, 400);
        // pieButton.setIcon(pie);
        // pieButton.setBorder(new RoundedBorder(200));
        // pieButton.setBackground(Color.WHITE);
        // panel.add(pieButton);

        // barButton.setIcon(bar);
        // barButton.setBounds(700, getHeight() + 100, 400, 400);
        // panel.add(barButton);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isIn(MouseEvent e, BufferedImage image) {
        if (e.getX() >= image.getMinX() && e.getX() <= (image.getMinX()+ image.getWidth()) 
            && e.getY() >= image.getMinY() && e.getY() <= (image.getMinY()+ image.getHeight())){
            return true;
        } 
        else return false;
    }
}

