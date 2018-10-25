package Monitors;

import java.util.ArrayList;

import obsPattern.Observer;
import obsPattern.Subject;
import weatherData.WeatherMonitor;

public abstract class GeneralMonitor implements Observer {

	@Override
	public abstract void update();

	/**
	 * @param update
	 *            Set the subject for a monitor in order to detach the subject
	 */
	public abstract void setSubject(Subject update);

	/**
	 * @return type of monitor string( graph/ text)
	 */
	public abstract String getType();

	/**
	 * @return String Returns locations name
	 */
	public abstract String getName();

	/**
	 * create view for a monitor
	 */

	public abstract void addView();

	/**
	 * @return arrayList<WeatherMonitors> Return weather data for a monitor
	 */
	public abstract ArrayList<WeatherMonitor> getWeatherData();
}
