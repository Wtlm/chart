package Interface;

import java.awt.*;

import javax.swing.*;

public class Project extends JFrame {

    Panel panel;

    public Project() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("INTERACTIVE CHART");
        setPreferredSize(new Dimension(1200, 600));
        setBackground(Color.decode("#f0f4f0"));
        setResizable(false);
        this.pack();

        panel = new Panel();
        add(panel);

        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void startThread() {
        panel.startThread();
    }

}
