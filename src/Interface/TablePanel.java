package Interface;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import Support.Table;
import Support.TableObserver;

public class TablePanel extends JPanel {
    public Table table;
    private List<TableObserver> observers = new ArrayList<>();

    public TablePanel() {
        this.setFocusable(true);
        // this.setSize(this.getWidth() / 3, this.getHeight());
        this.setIgnoreRepaint(true);
        table = new Table(this);
        this.setLayout(new BorderLayout());
        this.add(table.spTable, BorderLayout.CENTER);
    }

    public void getTableSize(Project project) {
        project.tablePanel.getSize();
    }

    public void addObserver(TableObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (TableObserver observer : observers) {
            observer.tableChanged();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        table.draw(g2);
    }
}