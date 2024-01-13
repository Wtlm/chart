package Stages;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.general.Dataset;

import Interface.Panel;
import Interface.TablePanel;
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

        tablePanel = new TablePanel();

        setData();

        chartPanel = new ChartPanel(chart);
        tablePanel.addObserver(this);
    }

    public void setData() {
        dataset = setDefaultData();
        chart = createChart(dataset);

    }

    public void addChart(Chart chart) {
        panel.add(chart.chartPanel, BorderLayout.CENTER);
        panel.add(chart.tablePanel, BorderLayout.WEST);
    }

    public Dataset setDefaultData() {
        return dataset;
    }

    public void updateChart() {

        setData();
        chartPanel.setChart(chart);
        chartPanel.repaint();

    }

    public boolean checkNum(String str) {
        try {
            Double.parseDouble(str);
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

    }

}
