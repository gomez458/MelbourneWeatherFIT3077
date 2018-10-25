package Services;

import weatherData.iRainfall;
import weatherData.iTemperature;
import weatherData.iTime;

public abstract class WeatherService implements iRainfall, iTime, iTemperature {
	/**
	 * @return 
	 * returns the string of locations from the service 
	 */
	public abstract String[] getLocations();

	/* (non-Javadoc)
	 * @see weatherData.iTemperature#getTemperature(java.lang.String)
	 */
	@Override
	public abstract String getTemperature(String n);

	/* (non-Javadoc)
	 * @see weatherData.iRainfall#getRainfall(java.lang.String)
	 */
	@Override
	public abstract String getRainfall(String n);

	/* (non-Javadoc)
	 * @see weatherData.iTime#getTime(java.lang.String)
	 */
	@Override
	public abstract String getTime(String n);
}
