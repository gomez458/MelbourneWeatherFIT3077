package Monitors;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import weatherData.WeatherMonitor;

public class CMonView {
	private DefaultCategoryDataset dataset;
	private JFreeChart BarChart;
	private JFrame chartFrame;
	private CumulativeMonitor m;
	private double lastTemp;
	private double lastRain;

	/**
	 * @param m
	 */
	/* sets the  monitor */
	public CMonView(CumulativeMonitor m) {

		this.m = m;

		this.chartFrame = new JFrame("Cumulative Monitor " + this.m.getName());
		this.chartFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.dataset = new DefaultCategoryDataset();
		this.BarChart = ChartFactory.createBarChart("Cumulative Weather ",
				"Total", "Weather", this.dataset, PlotOrientation.VERTICAL,
				true, true, false);

		ChartPanel chartPanel = new ChartPanel(BarChart);
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
		/**adds values to the chart */ 
	public void addToDataset(double data, String type, String time) {

		this.dataset.addValue(data, type, time); 
		this.chartFrame.revalidate();
		this.chartFrame.repaint();

	}

	/**
	 * closes the window frame
	 */
	public void closeWindow() {
		this.m.removeView(this);
		this.chartFrame.dispose();
	}

	/**
	 * update the view
	 */
	public void update() {

		String time = "";

		ArrayList<WeatherMonitor> w = this.m.getWeatherData();

		for (int i = 0; i < w.size(); i++) {

			if ((w.get(i).getType()).equalsIgnoreCase("time")) { // get type of
																	// monitor
																	// to use
																	// for graph
																	// lbls
				time = ((w.get(i)).getData());
			}

			if ((w.get(i)).getType().equalsIgnoreCase("temperature")) {

				if ((this.lastTemp - Double.parseDouble((w.get(i)).getData()) == 0)) {
				} else {
					addToDataset(Double.parseDouble((w.get(i)).getData()),
							"temperature", "Amount");
				}

			}
			if (w.get(i).getType().equalsIgnoreCase("rainfall")) {
				if ((this.lastRain - Double.parseDouble((w.get(i)).getData()) == 0)) {
				} else {
					addToDataset(Double.parseDouble((w.get(i)).getData()),
							"rainfall", " Amount ");
				}

			}
		}
	}
}
