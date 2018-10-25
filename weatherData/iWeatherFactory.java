package weatherData;

import Services.WeatherService;

public interface iWeatherFactory {
	/**
	 * @param monitorType
	 * @param service
	 * @return  WeatherMonitor 
	 * creates weather monitor of specified type 
	 */
	public WeatherMonitor getWeatherMonitor(String monitorType,
			WeatherService service);
}
