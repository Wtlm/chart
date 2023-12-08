package Stages;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;

import Interface.Panel;

public class Option {
    Panel panel;
    BufferedImage bgr;
    JLabel label;
    ImageIcon pie, bar;
    JButton pieButton, barButton;

    public Option(Panel panel) {
        this.panel = panel;
        label = new JLabel();
        pieButton = new JButton();
        barButton = new JButton();
        try {

            bgr = ImageIO.read(new File("D:/DSA/chart/Data/BGR.png"));
            pie = new ImageIcon("D:/DSA/chart/Data/Pie.png");
            bar = new ImageIcon("D:/DSA/chart/Data/Bar.png");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void draw(Graphics2D g2) {
        g2.drawImage(bgr, 0, 0, 1200, 600, null);
        addButton(panel);
    }

    public void addButton(Panel panel) {
        label.setText("Choose a chart");
        label.setBounds(0, 0, panel.getWidth(), 100);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 30));
        label.setForeground(Color.white);
        panel.add(label);

        pieButton.setIcon(pie);
        pieButton.setBounds(100, 100, 400, 400);
        panel.add(pieButton);

        barButton.setIcon(bar);
        barButton.setBounds(700, 100, 400, 400);
        panel.add(barButton);
    }

}
