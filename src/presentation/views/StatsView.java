package presentation.views;

import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;
import javax.swing.*;

public class StatsView extends JPanel{
    public void createLineChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Add data to the dataset
        dataset.addValue(10, "Series 1", "Category 1");
        dataset.addValue(15, "Series 1", "Category 2");
        dataset.addValue(8, "Series 1", "Category 3");
        dataset.addValue(12, "Series 1", "Category 4");

        // Create a line chart
        JFreeChart chart = ChartFactory.createLineChart(
                "Line Chart",      // Chart title
                "Category",        // X-axis label
                "Value",           // Y-axis label
                dataset,           // Dataset
                PlotOrientation.VERTICAL,
                true,              // Include legend
                true,              // Include tooltips
                false              // Include URLs
        );

        // Create a ChartPanel to display the chart
        ChartPanel chartPanel = new ChartPanel(chart);

        // Create a JFrame to hold the chart panel
        JFrame frame = new JFrame("Line Chart Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        // Add the chart panel to the frame
        frame.getContentPane().add(chartPanel);

        // Display the frame
        frame.setVisible(true);
    }

}
