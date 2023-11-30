package Stages;

import java.awt.Font;

import javax.swing.*;

import Interface.Panel;

public class Option {
    Panel panel;
    public Option(Panel panel){
        this.panel = panel;
        addButton(panel);
    }

    public void addButton(Panel panel){
        JLabel label = new JLabel("Choose a chart", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 30));
        ImageIcon pie = new ImageIcon("D:/DSA/chart/Chart/Data/Pie.png");
        ImageIcon bar = new ImageIcon("D:/DSA/chart/Chart/Data/Bar.png");
        JButton piebutton = new JButton(pie);
        JButton barbutton = new JButton(bar);
        piebutton.setBounds(400,100,100,100);
        barbutton.setBounds(200,200,100,100);

        panel.add(label);
        panel.add(piebutton);
        panel.add(barbutton);
    }


}
