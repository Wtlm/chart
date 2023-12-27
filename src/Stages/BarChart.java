package Stages;

import Interface.*;
import Support.Table;

import java.io.*;

import java.awt.Graphics;
import java.awt.image.*;

import javax.imageio.ImageIO;
import javax.swing.JLabel;


public class BarChart {
    public Panel panel;
    BufferedImage bgr;
    public Table table;
    public JLabel label;

    public BarChart(Panel panel) {
        this.panel = panel;
        label = new JLabel();
        table = new Table(label);
        try {
            bgr = ImageIO.read(new File("D:/DSA/chart/Data/BGR.png"));
        } catch (Exception e) {
            // TODO: handle exception
        }
        setBar(panel);
    }

    public void setBar(Panel panel){
        label.setBounds(0, 0, panel.getHeight(), panel.getWidth());
        panel.add(label);
    }

    public void draw(Graphics g) {
        g.drawImage(bgr, 0, 0, 1200, 600, null);
        if (panel.stage == panel.barStage) table = new Table(label);
        // table.draw(g);
        // table.spTable.setIgnoreRepaint(true);
        
    }
    
}
