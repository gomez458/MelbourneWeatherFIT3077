package app;

import org.apache.axis2.AxisFault;

import Services.MelTimeLapseAdapter;
import Services.WeatherService;

public class Main {

	public static void main(String[] args) throws AxisFault {

		WeatherService w = new MelTimeLapseAdapter();
		String[] locations = w.getLocations();

		// Create User Interface
		UI userInterface = new UI();

		userInterface.setLocationsList(locations);
		try {
			userInterface.createInterface();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
