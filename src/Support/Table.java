package Support;

import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import Interface.Panel;

public class Table implements TableModelListener {
    public Panel panel;
    DefaultTableModel tableModel;
    public static JTable table;
    public JScrollPane spTable;
    public BufferedImage bgr;
    public static int nColumn = 5, nRow = 5;
    public static Object[][] data;
    public static String[] item;
    ArrayList<String> values;

    public Table(Panel panel) {
        this.panel = panel;

        data = new Object[nRow][nColumn];
        item = new String[nColumn];

        table = new JTable();
        spTable = new JScrollPane(table);
        values = new ArrayList<String>();
        try {

            table.setCellSelectionEnabled(true);
            bgr = ImageIO.read(new File("D:/DSA/chart/Data/BGR.png"));
        } catch (Exception e) {
            // TODO: handle exception
        }
        setTable(panel);

    }

    public void draw(Graphics2D g2) {
        g2.drawImage(bgr, 0, 0, null);
        table.setBounds(0, 0, 500, 200);
        spTable.setLocation(0, 0);
        panel.add(spTable);
    }

    public void setTable(Panel panel) {

        table.setShowGrid(true);
        table.setModel(new DefaultTableModel(data, item));
        table.getModel().addTableModelListener(this);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setAutoscrolls(true);
        table.setFillsViewportHeight(true);
        spTable.setSize(panel.getWidth() / 3, panel.getHeight());
    }


    public void getValue() {

        for (int i = 0; i < table.getRowCount(); i++) {
            for (int j = 0; j < table.getColumnCount(); j++) {
                System.out.println(table.getValueAt(i, j));
            }
        }
        System.out.println();
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        getValue();
    }

}
