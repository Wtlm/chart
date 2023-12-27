package Interface;

import java.awt.*;

import javax.swing.*;

import Support.Table;

public class Project extends JFrame {

    Panel panel, tablePanel;
    Table table;
    private boolean chartStage = false;

    public Project() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("INTERACTIVE CHART");
        setPreferredSize(new Dimension(1200, 600));
        setBackground(Color.decode("#f0f4f0"));
        setResizable(false);
        this.pack();

        panel = new Panel();
        add(panel);
        // if (getChartStage() == true) {
        System.out.println(getChartStage());
        JPanel tablePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                Table table = new Table(this);
                table.draw(g2);
            }

        };

        tablePanel.setIgnoreRepaint(true);
        add(tablePanel);
        tablePanel.setSize(getWidth() / 3, getHeight());
        // }

        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void startThread() {
        panel.startThread();
    }

    public boolean getChartStage() {
        return chartStage;
    }

    public void setChartStage(boolean chartStage) {
        this.chartStage = chartStage;
    }
}
