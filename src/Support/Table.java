package Support;

import java.io.File;

import javax.imageio.ImageIO;

import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Interface.Panel;

public class Table {
    public Panel panel;
    public JScrollPane spTable;
    public BufferedImage bgr;
    public static int nColumn = 5, nRow = 5;
    public static Object[][] data;
    public static String[] item;
    int[][] a;

    public static JTable table;

    public Table(Panel panel){
        this.panel = panel;
        data = new Object[nRow][nColumn];
        table = new JTable(nRow + 1, nColumn);
        item = new String[nColumn];
        try {
            bgr = ImageIO.read(new File("D:/DSA/chart/Data/BGR.png"));
        } catch (Exception e) {
            // TODO: handle exception
        }
        setTable(panel);
        System.out.println(table.getColumnCount());
        System.out.println(table.getRowCount());
        

    }

    public void draw(Graphics g){
        g.drawImage(bgr, 0, 0, null);
        // setTable(panel);
    }

    public void setTable(Panel panel){
        table.setBounds(0, 0, 200, 200);
        table.setShowGrid(true);
        table.setModel(new DefaultTableModel(data, item));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        spTable = new JScrollPane(table);
        panel.add(spTable);
    }

    public Object[][] getData(){
        return data;
    }

    public String[] getItem(){
        return item;
    }

    public void display(JTable table){
        for(int i = 0; i < nRow; i++)
            for (int j = 0; j < nColumn; j++)
                a[i][j] = (int) table.getValueAt(i, j);
    }

    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        // fireTableCellUpdated(row, col);
    }
}
