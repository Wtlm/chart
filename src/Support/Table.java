package Support;

import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import java.awt.BorderLayout;
import java.awt.Graphics2D;
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
    // int[][] a;
    ArrayList<String> values;

    public Table(Panel panel) {
        this.panel = panel;

        data = new Object[nRow][nColumn];
        item = new String[nColumn];

        // tableModel = new DefaultTableModel(data, item);
        table = new JTable();
        values = new ArrayList<String>();
        try {

            table.setCellSelectionEnabled(true);
            // tableModel.fireTableDataChanged();
            bgr = ImageIO.read(new File("D:/DSA/chart/Data/BGR.png"));
        } catch (Exception e) {
            // TODO: handle exception
        }
        setTable(panel);
        // updateTable();

    }

    public void draw(Graphics2D g2) {
        g2.drawImage(bgr, 0, 0, null);
        // setTable(panel);
        // getValue();
    }

    public void setTable(Panel panel) {
        table.setBounds(0, 0, 500, 200);

        table.setShowGrid(true);
        table.setModel(new DefaultTableModel(data, item));
        table.getModel().addTableModelListener(this);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        spTable = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        // panel.add(table);

        panel.add(spTable);

    }

    // public void updateTable(TableModelEvent e) {
    // try {
    // while (table.getCellSelectionEnabled()) {
    // int row = e.getFirstRow();
    // int column = e.getColumn();
    // data[row][column] = tableModel.getValueAt(row, column);
    // }
    // } catch (Exception event) {
    // // TODO: handle exception
    // }
    // }

    public void getValue() {

        for (int i = 0; i < table.getRowCount(); i++) {
            for (int j = 0; j < table.getColumnCount(); j++) {
                // if (table.getValueAt(i, j) != null)
                System.out.println(table.getValueAt(i, j));
            }
        }
        System.out.println();
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        // int row = table.getSelectedRow();
        // int column = table.getSelectedColumn();
        // tableModel = (DefaultTableModel) e.getSource();
        getValue();
        // System.out.println(table.getValueAt(row, column).toString());
    }

}
