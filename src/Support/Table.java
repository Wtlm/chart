package Support;

import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import Interface.TablePanel;

public class Table implements TableModelListener {
    public TablePanel panel;
    DefaultTableModel tableModel;
    public static JTable table;
    public JScrollPane spTable;
    public BufferedImage bgr;
    public static int nColumn = 6;
    public static String[][] data;
    public static String[] item;

    public Table(TablePanel tablePanel) {
        this.panel = tablePanel;
        data = new String[][] { { "Label ", "Category1", "Category2", "Category3", "Category4", "Category5" },
                { "Item1", "12", "34", "23", "57", "98" } };
        item = new String[nColumn];
        table = new JTable();
        spTable = new JScrollPane(table);
        tableModel = new DefaultTableModel(data, item);
        try {

            table.setCellSelectionEnabled(true);
            bgr = ImageIO.read(new File("D:/DSA/chart/Data/BGR.png"));
        } catch (Exception e) {
            // TODO: handle exception
        }
        setTable(panel);

    }

    public void draw(Graphics2D g2) {
        spTable.setBounds(0, 0, panel.getWidth(), panel.getHeight());
    }

    public void setTable(TablePanel tablePanel) {

        table.setShowGrid(true);
        table.setModel(tableModel);
        table.getModel().addTableModelListener(this);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setAutoscrolls(true);
        table.setFillsViewportHeight(true);

    }

    public void setDefaultTable() {

    }

    public String getValue(int row, int col) {
        return (String) table.getValueAt(row, col);
    }

    public void updateObservers() {
        if (panel != null) {
            panel.notifyObservers();
        }
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        if (e.getLastRow() == table.getRowCount() - 1) {
            tableModel.removeTableModelListener(this);
            tableModel.addRow(new String[table.getColumnCount()]);
            tableModel.addTableModelListener(this);
        }
        if (e.getColumn() == table.getColumnCount() - 1) {
            tableModel.removeTableModelListener(this);
            tableModel.addColumn(new String[table.getRowCount()]);
            tableModel.setColumnIdentifiers(new String[table.getColumnCount()]);
            tableModel.addTableModelListener(this);
        }
        updateObservers();

    }

    public int getRowCount() {
        return table.getRowCount();
    }

    public int getColumnCount() {
        return table.getColumnCount();
    }

}
