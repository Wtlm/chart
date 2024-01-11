package Interface;

import java.awt.*;

import javax.swing.*;

import Support.Table;

public class Project extends JFrame {

    Panel panel;
    TablePanel tablePanel;
    static int w;
    static int h;
    // private boolean chartStage = false;

    public Project() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("INTERACTIVE CHART");
        setPreferredSize(new Dimension(1200, 600));
        setBackground(Color.decode("#f0f4f0"));
        setResizable(false);
        this.pack();
        this.setLayout(new BorderLayout());
        panel = new Panel();
        add(panel, BorderLayout.CENTER);
        // if (getChartStage() == true) {
        // System.out.println(getChartStage());
        // JPanel tablePanel = new JPanel() {
        // @Override
        // protected void paintComponent(Graphics g) {
        // super.paintComponent(g);
        // Graphics2D g2 = (Graphics2D) g;
        // Table table = new Table(this);
        // table.draw(g2);
        // }

        // };
        // tablePanel.setPreferredSize(new Dimension(this.getWidth() / 3,
        // this.getHeight()));
        // tablePanel.setIgnoreRepaint(true);
        //

        // tablePanel.getTableSize(this);

        // }

        // setW(tablePanel.getBounds().width);
        // setH(tablePanel.getHeight());
        // System.out.println(tablePanel.getBounds().width);

        // }
        // tablePanel = new TablePanel();
        // add(tablePanel, BorderLayout.WEST);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void setW(int w) {
        Project.w = w;
    }

    public static void setH(int h) {
        Project.h = h;
    }

    public static int getW() {
        return w;
    }

    public static int getH() {
        return h;
    }

    public void startThread() {
        panel.startThread();
    }

    // public boolean getChartStage() {
    // return panel.getChartStage();

    // }

    // public void setChartStage() {
    // System.out.println(panel.chartStage);
    // }

    public void addTable() {
        tablePanel = new TablePanel();
        add(tablePanel, BorderLayout.WEST);
    }
}
