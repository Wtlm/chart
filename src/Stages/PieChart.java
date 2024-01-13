package Stages;

import java.awt.Color;
import java.util.Random;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import Interface.Panel;

public class PieChart extends Chart {
    public PieChart(Panel panel) {
        super(panel);
    }

    @Override
    public JFreeChart createChart(Dataset dataset) {
        JFreeChart pieChart = ChartFactory.createPieChart("name", (PieDataset) dataset, true, true, false);
        PiePlot pp = (PiePlot) pieChart.getPlot();
        for (int i = 1; i < 100; i++) {
            Random rand = new Random();
            int j = rand.nextInt(120) + 130;
            int k = rand.nextInt(120) + 130;
            Color c = new Color(j, k, 219);
            if (tablePanel.table.getColumnCount() >= k)
                pp.setSectionPaint(tablePanel.table.getValue(0, i), c);
            else break;
        }
        return pieChart;

    }

    @Override
    public Dataset setDefaultData() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (int i = 1; i < tablePanel.table.getRowCount(); i++) {
            for (int j = 1; j < tablePanel.table.getColumnCount(); j++) {
                String columnKey = tablePanel.table.getValue(0, j);
                String value = tablePanel.table.getValue(1, j);

                if (value != null && checkNum(value)) {
                    Number val = Double.parseDouble(value);
                    dataset.setValue((Comparable) columnKey, (Number) val);
                    System.out.println(val);
                }

            }
        }
        return dataset;
    }


    @Override
    public void tableChanged() {
        super.tableChanged();
    }

}
