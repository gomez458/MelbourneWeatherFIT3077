package Monitors;

import java.util.ArrayList;

import weatherData.WeatherMonitor;

public class MonitorFactory implements iMonitorFactory {

	private static MonitorFactory instance = null;

	protected MonitorFactory() {
		// Exists only to defeat instantiation.
	}

	public static MonitorFactory getInstance() {
		if (instance == null) {
			instance = new MonitorFactory();
		}
		return instance;
	}

	@Override
	public GeneralMonitor getMonitor(String monitorType,
			ArrayList<WeatherMonitor> data, String name) {

		if (monitorType.equalsIgnoreCase("TEXT")) {
			return new Monitor(name, data);
		}
		if (monitorType.equalsIgnoreCase("GRAPH")) {
			return new GraphMonitor(name, data);
		}
		if (monitorType.equalsIgnoreCase("BARCHART")) {
			return new CumulativeMonitor(name, data);
		}
		return null;

	}
}
