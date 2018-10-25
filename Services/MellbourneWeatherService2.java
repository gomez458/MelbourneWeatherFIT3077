package Services;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import melbourneweather2.ExceptionException;
import melbourneweather2.MelbourneWeather2Stub;
import melbourneweather2.MelbourneWeather2Stub.GetLocationsResponse;
import melbourneweather2.MelbourneWeather2Stub.GetRainfall;
import melbourneweather2.MelbourneWeather2Stub.GetRainfallResponse;
import melbourneweather2.MelbourneWeather2Stub.GetTemperature;
import melbourneweather2.MelbourneWeather2Stub.GetTemperatureResponse;

public class MellbourneWeatherService2 extends WeatherService {

	private String TimeStamp;

	private String[] rainfall;

	final MelbourneWeather2Stub MelbourneWeatherService = new MelbourneWeather2Stub();;

	public MellbourneWeatherService2() throws AxisFault {

	}

	@Override
	public String[] getLocations() {

		// Get the available locations from the web service
		GetLocationsResponse LocationsResponse = null;
		try {
			LocationsResponse = MelbourneWeatherService.getLocations();
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

	@Override
	public String getTemperature(String name) {

		// Get temperature
		GetTemperature TemperatureRequest = new GetTemperature();
		TemperatureRequest.setLocation(name);
		GetTemperatureResponse TemperatureResponse = null;
		try {
			TemperatureResponse = MelbourneWeatherService
					.getTemperature(TemperatureRequest);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExceptionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] Temperature = TemperatureResponse.get_return();

		this.TimeStamp = Temperature[0];

		return Temperature[1];

	}

	@Override
	public String getRainfall(String name) {

		return this.rainfall[1];

	}

	@Override
	public String getTime(String name) {

		GetRainfall RainfallRequest = new GetRainfall();
		RainfallRequest.setLocation(name);
		GetRainfallResponse RainfallResponse = null;
		try {
			RainfallResponse = MelbourneWeatherService
					.getRainfall(RainfallRequest);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExceptionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] Rainfall = RainfallResponse.get_return();
		this.rainfall = Rainfall;

		return Rainfall[0];

	}
}
