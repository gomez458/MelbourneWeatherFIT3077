package weatherData;

import javax.swing.JLabel;

public interface WeatherMonitor {

	/**
	 * @return
	 * returns a label for display 
	 */
	public JLabel display();

	/**
	 * @param name
	 * call service to update 
	 */
	public void update(String name);

	/**
	 * @return String of weather data
	 */
	public String getData();

	/**
	 * @return
	 * returns the type of weather monitor ( rainfall/ temperature/time ) 
	 */
	public String getType();

}

// We assume that in terms of having more than one monitor per location
// this imply that we have more than one kind of weather monitor for example
// temperature and/or rainfall