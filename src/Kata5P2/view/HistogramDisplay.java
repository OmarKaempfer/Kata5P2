package Kata5P2.view;

import Kata5P2.model.Histogram;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import javax.swing.*;
import java.awt.*;


public class HistogramDisplay extends ApplicationFrame {

    private final Histogram<String> histogram;

    public HistogramDisplay(Histogram<String> histogram) {
        super("HISTOGRAMA");
        this.histogram = histogram;
        setContentPane(createPanel());
        pack();
    }

    private JPanel createPanel() {
        ChartPanel chartPanel =
                new ChartPanel(createChart(createDataset()));
        chartPanel.setPreferredSize(new Dimension(500, 400));
        return chartPanel;
    }

    private JFreeChart createChart(DefaultCategoryDataset dataSet) {
        return ChartFactory.createBarChart("Histograma JFreeChart", "Dominios email",
                "Nº de emails", dataSet, PlotOrientation.VERTICAL, false,
                rootPaneCheckingEnabled, rootPaneCheckingEnabled);
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for (String key : histogram.keySet()) {
            dataSet.addValue(histogram.get(key), "", key);
        }

        return dataSet;
    }

    public void execute() {
        setVisible(true);
    }
}
