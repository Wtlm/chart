package Stages;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;


import javax.imageio.ImageIO;
import javax.swing.border.*;

import Action.MouseHandler;
import Interface.Panel;

public class Option {
    Panel panel;
    public BufferedImage bgr, pie1, pie2, bar1, bar2;
    JLabel label, pie, bar;
    private int height;
    public int chooseBar, choosePie;

    public Option(Panel panel) {
        this.panel = panel;
        label = new JLabel();
        pie = new JLabel();
        bar = new JLabel();
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

        pie.setBounds(100, getHeight() + 100, 400, 400);
        pie.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                panel.stage = 2;
                panel.remove(label);
                panel.remove(pie);
                panel.remove(bar);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                choosePie = 1;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                choosePie = 0;
            }
            
        });
        panel.add(pie);
        bar.setBounds(700, getHeight() + 100, 400, 400);
        bar.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                panel.stage = 3;
                panel.remove(label);
                panel.remove(pie);
                panel.remove(bar);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                chooseBar = 1;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                chooseBar = 0;
            }
            
        });
        panel.add(bar);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}

