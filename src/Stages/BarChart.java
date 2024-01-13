package Stages;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.Dataset;

import Interface.Panel;

public class BarChart extends Chart {
    public BarChart(Panel panel) {
        super(panel);

    }

    @Override
    public JFreeChart createChart(Dataset dataset) {
        JFreeChart barChart = ChartFactory.createBarChart("name", "Xname", "Yname", (CategoryDataset) dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        return barChart;

    }

    @Override
    public Dataset setDefaultData() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int i = 1; i < tablePanel.table.getRowCount(); i++) {
            for (int j = 1; j < tablePanel.table.getColumnCount(); j++) {
                String rowKey = tablePanel.table.getValue(i, 0);
                String columnKey = tablePanel.table.getValue(0, j);
                String value = tablePanel.table.getValue(i, j);

                if (value != null && checkNum(value)) {
                    Number val = Double.parseDouble(value);
                    dataset.addValue((Number) val, (Comparable) rowKey, (Comparable) columnKey);
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
