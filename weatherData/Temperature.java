package weatherData;

import javax.swing.JLabel;

public class Temperature implements WeatherMonitor {

	private String type;
	private iTemperature service;

	private String temperature;

	public Temperature(iTemperature temp) {
		this.type = "Temperature";
		this.service = temp;

	}

	@Override
	public void update(String name) {

		this.temperature = service.getTemperature(name);

	}

	@Override
	public String getData() {

		return this.temperature;
	}

	@Override
	public JLabel display() {

		JLabel j = new JLabel("\n\tTemperature:\t" + this.getData());
		j.setSize(400, 30);
		return j;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return this.type;
	}

}
