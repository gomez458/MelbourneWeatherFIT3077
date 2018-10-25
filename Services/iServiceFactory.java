package Services;

import org.apache.axis2.AxisFault;

public interface iServiceFactory {

	/**
	 * @param name
	 * @return WeatherService 
	 * @throws AxisFault
	 * create service objects to be used to access the weather
	 */
	public WeatherService createService(String name) throws AxisFault;
}
