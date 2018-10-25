package monitors;

import java.util.ArrayList;

import weatherData.WeatherMonitor;

public interface iMonitorFactory {

	/**
	 * @param Type
	 * @param weatherMonitors
	 * @param name
	 * @return
	 * Create Monitor give type receive monitor of that type
	 */
	public GeneralMonitor getMonitor(String Type,
			ArrayList<WeatherMonitor> weatherMonitors, String name);

}
