package Services;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import melbourneweathertimelapse.ExceptionException;
import melbourneweathertimelapse.MelbourneWeatherTimeLapseStub;
import melbourneweathertimelapse.MelbourneWeatherTimeLapseStub.GetLocationsResponse;
import melbourneweathertimelapse.MelbourneWeatherTimeLapseStub.GetWeather;
import melbourneweathertimelapse.MelbourneWeatherTimeLapseStub.GetWeatherResponse;

public class MelTimeLapseAdapter extends WeatherService {
	static MelbourneWeatherTimeLapseStub MelTimelapse;

	private String temp;
	private String rainfall;
	private GetWeatherResponse weatherResponse;

	/**
	 * constructor
	 */
	public MelTimeLapseAdapter() {
		try {
			MelTimelapse = new MelbourneWeatherTimeLapseStub();
		} catch (AxisFault a) {
			a.printStackTrace();
		}
	}

	public void getWeatherData() {

	}

	/* (non-Javadoc)
	 * @see Services.WeatherService#getLocations()
	 */
	@Override
	public String[] getLocations() {

		GetLocationsResponse LocationsResponse = null;
		try {
			LocationsResponse = MelTimelapse.getLocations();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExceptionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] Locations = LocationsResponse.get_return();
		return Locations;
	}

	/* (non-Javadoc)
	 * @see Services.WeatherService#getTemperature(java.lang.String)
	 */
	@Override
	public String getTemperature(String name) {

		String[] weather = this.weatherResponse.get_return();
		this.temp = weather[1];
		double kelvin = Double.parseDouble((temp));
		kelvin = kelvin - 273.15;
		this.temp = Double.toString(kelvin);// convert to degrees 

		return this.temp;
	}

	@Override
	public String getRainfall(String name) {

		String[] weather = this.weatherResponse.get_return();
		this.rainfall = weather[2];
		double rainConversion = (Double.parseDouble(this.rainfall) * 10); //convert to cm 
		this.rainfall = (String.valueOf(rainConversion));

		return this.rainfall;
	}
// get update time for data 
	@Override
	public String getTime(String name) {
		GetWeather weatherRequest = new GetWeather();
		weatherRequest.setLocation(name);
		GetWeatherResponse weatherResponse = null;
		try {
			this.weatherResponse = MelTimelapse.getWeather(weatherRequest);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExceptionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] weather = this.weatherResponse.get_return();
		return weather[0];

	}

}
