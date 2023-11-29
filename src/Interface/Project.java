package Interface;
import java.awt.*;

import javax.swing.*;

public class Project extends JFrame{

    Panel Panel;

    public Project(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("INTERACTIVE CHART");
        setPreferredSize(new Dimension(1500, 750));
        setBackground(Color.decode("#f0f4f0"));
        setResizable(false);
        this.pack();

        Panel = new Panel();
        add(Panel);

        setLocationRelativeTo(null);
        setVisible(true);

    }


}
