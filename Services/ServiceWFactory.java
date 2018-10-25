package Services;

import org.apache.axis2.AxisFault;

public class ServiceWFactory implements iServiceFactory {
	private static ServiceWFactory instance = null;

	protected ServiceWFactory() {
		// Exists only to defeat instantiation.
	}

	public static ServiceWFactory getInstance() {
		if (instance == null) {
			instance = new ServiceWFactory();
		}
		return instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Services.iServiceFactory#createService(java.lang.String)
	 */
	@Override
	public WeatherService createService(String n) throws AxisFault {
		if (n == "MelbournWeather2") {
			return new MellbourneWeatherService2();
		}
		if (n == "MelbourneTimelapse") {
			return new MelTimeLapseAdapter();
		}
		return null;

	}
}
