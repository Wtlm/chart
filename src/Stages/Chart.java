package Stages;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.Dataset;

import Interface.Panel;
import Interface.TablePanel;
import Support.Table;
import Support.TableObserver;

public class Chart implements ActionListener, TableObserver {
    protected Dataset dataset;
    private JFreeChart chart;
    private CategoryPlot categoryPlot;
    private ChartPanel chartPanel;
    TablePanel tablePanel;
    Panel panel;

    public Chart(Panel panel) {
        this.panel = panel;
        panel.setLayout(new BorderLayout());

        tablePanel = new TablePanel();
        panel.add(tablePanel, BorderLayout.WEST);

        setData();

        chartPanel = new ChartPanel(chart);
        panel.add(chartPanel, BorderLayout.CENTER);
        // setData();
        tablePanel.addObserver(this);
    }

    public void setData() {
        dataset = setDefaultData();
        chart = createChart(dataset);
    }

    public Dataset setDefaultData() {
        return dataset;
    }

    public void updateChart() {
        // System.out.println(tablePanel.table.updateChart);
        // if (tablePanel.table.updateChart == true) {
        setData();
        chartPanel.setChart(chart);
        chartPanel.repaint();

        // for (Object rowKey : dataset.getRowKeys()) {
        // for (Object columnKey : dataset.getColumnKeys()) {
        // Number value = dataset.getValue((Comparable<?>) rowKey, (Comparable<?>)
        // columnKey);
        // System.out.println("Row: " + rowKey + ", Column: " + columnKey + ", Value: "
        // + value);
        // }
        // }
        // chart.getCategoryPlot().setDataset(dataset);
        // chartPanel.repaint();
        // }
    }

    public boolean checkNum(String str) {
        try {
            Double.parseDouble(str); // Use Double.parseDouble for floating-point numbers
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public JFreeChart createChart(Dataset dataset2) {
        return chart;
    }

    public void setColor() {

    }

    @Override
    public void tableChanged() {
        updateChart();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // categoryPlot.setDataset(dataset);
        // if (e.getSource() == dataset) {
        // chart = createChart(dataset);
        // panel.add(tablePanel, BorderLayout.CENTER);
        // tablePanel.repaint();
        // }

    }
}
