package Stages;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

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
        try {
            bgr = ImageIO.read(new File("D:/DSA/chart/Data/BGR.png"));
            pie = new ImageIcon("D:/DSA/chart/Chart/Data/Pie.png");
            bar = new ImageIcon("D:/DSA/chart/Chart/Data/Bar.png");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        pieButton = new JButton(pie);
        barButton = new JButton(bar);
    }

    public void draw(Graphics g) {
        g.drawImage(bgr, 0, 0, null);
        addButton(panel);
    }

    public void addButton(Panel panel) {
        label.setText("Choose a chart");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 30));

        pieButton.setBounds(400, 100, 100, 100);
        barButton.setBounds(200, 200, 100, 100);

        panel.add(label);
        panel.add(pieButton);
        panel.add(barButton);
    }

}
