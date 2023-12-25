package Support;

import java.io.File;
import java.util.ArrayList;

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

public class Table extends Component implements TableModelListener {
    public JPanel panel;
    DefaultTableModel tableModel;
    public static JTable table;
    public JScrollPane spTable;
    public BufferedImage bgr;
    public static int nColumn = 5, nRow = 5;
    public static Object[][] data;
    public static String[] item;
    ArrayList<String> values;

    public Table(JPanel tablePanel) {
        this.panel = tablePanel;

        data = new Object[nRow][nColumn];
        item = new String[nColumn];

        table = new JTable();
        spTable = new JScrollPane(table);
        values = new ArrayList<String>();
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
        // table.setBounds(0, 0, 500, 200);
        spTable.setLocation(0, 0);
        // spTable.getIgnoreRepaint();
        // setTable(panel);
        // getValue();
    }

    public void setTable(JPanel tablePanel) {

        table.setShowGrid(true);
        table.setModel(new DefaultTableModel(data, item));
        table.getModel().addTableModelListener(this);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setAutoscrolls(true);
        table.setFillsViewportHeight(true);
        // panel.add(table);
        spTable.setSize(tablePanel.getWidth() / 3, tablePanel.getHeight());
        tablePanel.add(spTable);

    }

    public void getValue() {

        for (int i = 0; i < table.getRowCount(); i++) {
            for (int j = 0; j < table.getColumnCount(); j++) {
                System.out.println(table.getValueAt(i, j));

            }
        }
        System.out.println();
        // for (int j = 0; j < table.getColumnCount(); j++) {
        // System.out.println(item[j]);
        // }
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        getValue();
    }

}
