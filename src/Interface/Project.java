package Interface;

import java.awt.*;
import javax.swing.*;

public class Project extends JFrame {

    Panel panel;
    TablePanel tablePanel;

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

        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void startThread() {
        panel.startThread();
    }

}
