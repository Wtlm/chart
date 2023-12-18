package Interface;

import java.awt.*;

import javax.swing.*;

import Support.Table;

public class Project extends JFrame {

    Panel panel, tablePanel;
    Table table;

    public Project() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("INTERACTIVE CHART");
        setPreferredSize(new Dimension(1200, 600));
        setBackground(Color.decode("#f0f4f0"));
        setResizable(false);
        this.pack();

        panel = new Panel();
        add(panel);

        tablePanel = new Panel(table);

        panel.add(tablePanel, BorderLayout.EAST);

        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void startThread() {
        panel.startThread();
    }

}
