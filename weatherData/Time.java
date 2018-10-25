package weatherData;

import javax.swing.JLabel;

import org.apache.axis2.AxisFault;

public class Time implements WeatherMonitor {
	private String timestamp;
	private String type;
	private JLabel lblTime;
	iTime service;

	public Time(iTime time) throws AxisFault {
		this.service = time;
		this.type = "time";

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see weatherData.WeatherMonitor#getData()
	 */
	@Override
	public String getData() {

		return this.timestamp;
	}

	@Override
	public void update(String name) {

		this.timestamp = service.getTime(name);

	}

	// Called to display output in the JTextArea

	/*
	 * (non-Javadoc)
	 * 
	 * @see weatherData.WeatherMonitor#display()
	 */
	@Override
	public JLabel display() {
		this.lblTime = new JLabel();
		this.lblTime.setText(("\n\t@ Time:\t" + getData())); // format lbl content 
		this.lblTime.setSize(400, 30);
		return this.lblTime;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return this.type;
	}

}