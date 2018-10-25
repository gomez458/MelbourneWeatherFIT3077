package Monitors;

import java.util.ArrayList;

import obsPattern.Subject;
import weatherData.WeatherMonitor;

public class CumulativeMonitor extends GeneralMonitor {
	private String name;
	private ArrayList<WeatherMonitor> weatherMonitors;

	private ArrayList<CMonView> views;
	private Subject subject;
	private String type;
	private boolean view = false;  
	

	/**
	 * @param name
	 * @param w
	 */
	public CumulativeMonitor(String name, ArrayList<WeatherMonitor> w) {
		this.name = name;
		this.type = "Barchart";
		this.weatherMonitors = w;

		this.views = new ArrayList<CMonView>();
		addView();
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Monitors.GeneralMonitor#getType()
	 */
	@Override
	public String getType() {
		return this.type;
	}

	@Override
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setSubject(Subject s) {
		this.subject = s;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Monitors.GeneralMonitor#addView()
	 */

	@Override
	public void addView() {
		if(this.view){
			this.subject.attach(this);
		}
		CMonView v = new CMonView(this);
		this.views.add(v);
		if ((this.views.size() > 1)) {
			v.update();
		}
	}
	/* removes monitor from view */ 
	public void removeView(CMonView v) {

		this.views.remove(v);
		if (views.isEmpty()) {
			System.out.println("Dettach"); // detach from subject if no more
               							// views
			this.subject.detach(this);
			this.view = true; 
		}
	}

	@Override
	public ArrayList<WeatherMonitor> getWeatherData() {
		return this.weatherMonitors;
	}

	public void setWeatherData(ArrayList<WeatherMonitor> w) {
		this.weatherMonitors = w;
	}

	@Override
	public void update() {
		// Don't update if there are no view for the location

		if (!(views.isEmpty())) {

			for (int i = 0; i < this.weatherMonitors.size(); i++) {
				(weatherMonitors.get(i)).update(this.name);
			}

			for (int i = 0; i < this.views.size(); i++) {
				this.views.get(i).update();

			}

		}

	}
}
