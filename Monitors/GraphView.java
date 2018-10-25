package Monitors;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import Monitors.GraphMonitor;
import weatherData.WeatherMonitor;

public class GraphView {
	private DefaultCategoryDataset dataset;
	private JFreeChart lineChart;
	private JFrame chartFrame;
	private GraphMonitor m;

	public GraphView(GraphMonitor m) {
		this.m = m;
		this.chartFrame = new JFrame("Graph Monitor " + this.m.getName());
		this.chartFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.dataset = new DefaultCategoryDataset();
		this.lineChart = ChartFactory.createLineChart("Weather Vs Time",
				"Time", "Weather Measurement", this.dataset,
				PlotOrientation.VERTICAL, true, true, false);

		ChartPanel chartPanel = new ChartPanel(lineChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));

		this.chartFrame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				closeWindow();
			}
		});
		this.chartFrame.setContentPane(chartPanel);
		this.chartFrame.pack();
		this.chartFrame.setVisible(true);

	}

	/**
	 * @param data
	 * @param type
	 * @param time
	 */
	public void addToDataset(double data, String type, String time) {

		this.dataset.addValue(data, type, time);
		this.chartFrame.revalidate();
		this.chartFrame.repaint();

	}

	/**
	 * close window method to remove monitor views
	 */
	public void closeWindow() {
		System.out.println("dispose");
		this.m.removeView(this);
		this.chartFrame.dispose();
	}

	public void update() {

		String time = "";

		ArrayList<WeatherMonitor> w = this.m.getWeatherData();

		for (int i = 0; i < w.size(); i++) {

			if ((w.get(i).getType()).equalsIgnoreCase("time")) {
				time = ((w.get(i)).getData());
			}

			if ((w.get(i)).getType().equalsIgnoreCase("temperature")) {
				addToDataset(Double.parseDouble((w.get(i)).getData()),
						"temperature", time);

			}
			if (w.get(i).getType().equalsIgnoreCase("rainfall")) {
				addToDataset(Double.parseDouble((w.get(i)).getData()),
						"rainfall", time);

			}
		}
	}
}