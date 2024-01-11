package Support;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;

import java.awt.Component;
import java.awt.Graphics2D;

import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import Interface.Project;
import Interface.TablePanel;

public class Table implements TableModelListener {
    public TablePanel panel;
    DefaultTableModel tableModel;
    public static JTable table;
    public JScrollPane spTable;
    public BufferedImage bgr;
    public static int nColumn = 5, nRow = 5;
    public static String[][] data;
    public static String[] item;
    public boolean updateChart = false;

    public Table(TablePanel tablePanel) {
        this.panel = tablePanel;
        data = new String[][] { { "Label ", "Category1", "Category2", "Category3", "Category4" },
                { "Item1", "12", "34", "23", "57" } };
        // data = new Object[nRow][nColumn];
        item = new String[nColumn];
        // setDefaultTable();
        table = new JTable();
        spTable = new JScrollPane(table);
        tableModel = new DefaultTableModel(data, item);
        try {
            table.setIgnoreRepaint(true);
            table.setCellSelectionEnabled(true);
            bgr = ImageIO.read(new File("D:/DSA/chart/Data/BGR.png"));
        } catch (Exception e) {
            // TODO: handle exception
        }
        setTable(panel);

    }

    public void draw(Graphics2D g2) {
        // g2.drawImage(bgr, 0, 0, null);
        // table.setBounds(0, 0, 500, 600);
        spTable.setBounds(0, 0, 500, 600);

        // spTable.setSize(700, 700);
        // spTable.getIgnoreRepaint();
        // setTable(panel);
        // getValue();
    }
    // public void setTableSize(Project project) {
    // spTable.setSize(project.getSize());
    // }

    public void setTable(TablePanel tablePanel) {

        table.setShowGrid(true);
        table.setModel(tableModel);
        table.getModel().addTableModelListener(this);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setAutoscrolls(true);
        table.setFillsViewportHeight(true);
        // table.setSize(tablePanel.getPreferredSize().width,
        // tablePanel.getPreferredSize().height);
        // panel.add(table);
        // spTable.setSize(tablePanel.getPreferredSize().width,
        // tablePanel.getPreferredSize().height);
        // System.out.println(Project.getW() + " " + Project.getH());

        tablePanel.add(spTable);

    }

    public void setDefaultTable() {

    }

    public String getValue(int row, int col) {

        // for (int i = 0; i < table.getRowCount(); i++) {
        // for (int j = 0; j < table.getColumnCount(); j++) {
        // System.out.println(table.getValueAt(i, j));

        // }
        // }
        // System.out.println();
        // for (int j = 0; j < table.getColumnCount(); j++) {
        // System.out.println(item[j]);
        // }
        return (String) table.getValueAt(row, col);
    }

    public void display() {
        // for(int i = 0; i < table.get)
        // System.out.println(Arrays.toString(getRowHeader()));
        // System.out.println(Arrays.toString(getColumnHeader()));
        // for (int i = 0; i < getRowHeader().length; i++) {
        // System.out.println(getRowHeader()[i]);
        // System.out.println(getColumnHeader()[i]);
        // }
    }

    public Object getHeader(int row, int col) {

        // String[] rowHeader = new String[table.getColumnCount()];
        // if (table.getRowCount() > 0) {
        // for (int i = 0; i < table.getColumnCount(); i++) {
        // rowHeader[i] = (String) table.getValueAt(0, i);
        // // System.out.println(rowHeader[i]);
        // }
        // }
        // System.out.println();
        return table.getValueAt(row, col);
    }

    public Object getColumnHeader() {
        String[] colHeader = new String[table.getRowCount()];
        if (table.getColumnCount() > 0) {
            for (int i = 0; i < table.getRowCount(); i++) {
                colHeader[i] = (String) table.getValueAt(i, 0);
                // System.out.println(colHeader[i]);
            }
        }
        System.out.println();
        return colHeader;
    }

    public void updateObservers() {
        if (panel != null) {
            panel.notifyObservers();
        }
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        // getValue();
        // display();
        // getRowHeader();
        // getColumnHeader();

        // display();
        // if (e.UPDATE == 1)
        updateChart = true;
        System.out.println(updateChart);
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

        // else
        // updateChart = false;
    }

    public int getRowCount() {
        return table.getRowCount();
    }

    public int getColumnCount() {
        return table.getColumnCount();
    }

}
