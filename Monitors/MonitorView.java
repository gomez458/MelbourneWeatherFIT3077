package Monitors;

import javax.swing.*;

import weatherData.WeatherMonitor;

import java.awt.Color;
import java.awt.Font;

import java.util.*;

public class MonitorView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame view;
	private Monitor m;
	private JPanel pan;

	public MonitorView(Monitor m) {
		// this.setting = s ;
		this.m = m;
		this.view = new JFrame();
		this.view.setLayout(null);
		this.view.setResizable(false);
		this.view.setSize(400, 150);
		this.view.setTitle(m.getName() + " Monitor");

		this.view.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				closeWindow();
			}
		});

		// view.getContentPane().setLayout( new BoxLayout(view.getContentPane(),
		// BoxLayout.PAGE_AXIS));
		this.pan = new JPanel();
		this.pan.setLocation(0, 0);
		this.pan.setLayout(new BoxLayout(this.pan, BoxLayout.PAGE_AXIS));
		this.pan.setSize(400, 150);
		this.pan.setBackground(Color.white);

		this.view.add(this.pan);

	}

	public void update() {

		this.pan.removeAll();
		// Title Label for Monitor
		JLabel lblTitle = new JLabel("Monitor Location:" + this.m.getName());
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTitle.setSize(400, 70);
		lblTitle.setForeground(Color.BLUE);

		lblTitle.setSize(70, 20);
		this.pan.add(lblTitle);

		ArrayList<WeatherMonitor> weatherMonitors = this.m.getWeatherData();

		for (int i = 0; i < weatherMonitors.size(); i++) {

			this.pan.add(weatherMonitors.get(i).display());

		}
		this.pan.revalidate();
		this.pan.repaint();

		this.view.setVisible(true);

	}

	public void closeWindow() {

		this.m.removeView(this);
		System.out.println("dispose");
		this.view.dispose();
	}
}

// Detach Observer when a window is closed

