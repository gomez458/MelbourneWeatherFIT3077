package app;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import controller.Controller;

public class UI {

	private String[] locations;

	// Create UI
	/**
	 * @throws Exception
	 *             Create the user interface
	 */
	public void createInterface() throws Exception {
		final JFrame frame = new JFrame("Weather Monitor");
		frame.setSize(400, 600);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.getContentPane().setForeground(Color.orange);
		frame.getContentPane().setBackground(Color.WHITE);

		frame.setResizable(false);

		// Jpanel
		JPanel lpan = new JPanel();
		lpan.setLayout(null);
		lpan.setBackground(Color.WHITE);
		lpan.setBorder(BorderFactory.createEtchedBorder());
		lpan.setSize(380, 550);
		lpan.setLocation(7, 10);

		// Title Label
		JLabel lblTitle = new JLabel("Melbourne Weather");

		lblTitle.setFont(new Font("Tahoma", Font.ITALIC, 24));
		lblTitle.setSize(300, 30);
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setLocation(10, 15);
		lblTitle.setBorder(BorderFactory.createLoweredSoftBevelBorder());

		frame.add(lblTitle);

		// Select Setting Label
		JLabel lblSet = new JLabel("Select Settings:			");
		lblSet.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSet.setSize(350, 15);
		lblSet.setLocation(10, 60);
		// lblSet.setBorder(BorderFactory.createLineBorder(Color.red));

		// Check Box

		final JCheckBox cbTemp = new JCheckBox("Tempreture");
		cbTemp.setBackground(Color.WHITE);
		cbTemp.setSize(250, 15);
		cbTemp.setLocation(10, 90);

		final JCheckBox cbRainfall = new JCheckBox("Rainfall");
		cbRainfall.setBackground(Color.WHITE);
		cbRainfall.setLocation(10, 120);
		cbRainfall.setSize(350, 15);

		// Select Location Label
		JLabel lblSelLocation = new JLabel("Select Locations:			");
		lblSelLocation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSelLocation.setSize(300, 15);
		lblSelLocation.setLocation(10, 150);
		// lblSelLocation.setBorder(BorderFactory.createLineBorder(Color.red));

		// ComboBox for Locations

		final JComboBox<String> cbLocationMonitors = new JComboBox<String>(
				locations);
		cbLocationMonitors.setSelectedIndex(0);
		cbLocationMonitors.setSize(300, 25);
		cbLocationMonitors.setLocation(10, 180);

		// Select Service Label
		JLabel lblService = new JLabel("Select Weather Service:			");
		lblService.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblService.setSize(350, 15);
		lblService.setLocation(10, 220);

		// ComboBox for Weather Services
		final String[] services = { "MelbournWeather2", "MelbourneTimelapse" };
		final JComboBox<String> cbService = new JComboBox<String>(services);
		cbService.setSize(300, 25);
		cbService.setLocation(10, 250);
		cbService.setSelectedIndex(0);

		// Select Service Label
		JLabel lblMonType = new JLabel("Select Monitor Type:			");
		lblMonType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMonType.setSize(350, 15);
		lblMonType.setLocation(10, 300);

		// ComboBox for Weather Services
		final String[] monitorType = { "Text", "Graph", "Barchart" };
		final JComboBox<String> cbMonitorType = new JComboBox<String>(
				monitorType);
		cbMonitorType.setSize(300, 25);
		cbMonitorType.setSelectedIndex(0);
		cbMonitorType.setLocation(10, 330);

		// Add to scPane
		lpan.add(lblSet);
		lpan.add(lblService);
		lpan.add(lblMonType);
		lpan.add(cbTemp);
		lpan.add(cbRainfall);
		lpan.add(cbMonitorType);
		lpan.add(cbService);
		lpan.add(lblSelLocation);
		lpan.add(cbLocationMonitors);

		// View buttons must be clicked to process settings
		JButton view = new JButton("View");
		view.setSize(100, 40);
		view.setLocation(260, 510);
		view.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				boolean rainfall = cbRainfall.isSelected();
				boolean temp = cbTemp.isSelected();

				if ((rainfall || temp)) {

					String location = locations[cbLocationMonitors
							.getSelectedIndex()];

					String monType = monitorType[cbMonitorType
							.getSelectedIndex()];

					String service = services[cbService.getSelectedIndex()];

					ArrayList<String> weatherData = new ArrayList<String>();
					weatherData.add("TIME");
					if (temp == true) {
						weatherData.add("TEMPERATURE");
					}

					if (rainfall == true) {
						weatherData.add("RAINFALL");
					}

					Controller.getInstance().createMonitor(location, monType,
							service, weatherData);
				} else {
					JOptionPane
							.showMessageDialog(frame,
									"Please select a location to view and a weather settings");

				}

			}

		});

		// Add components to Frame
		frame.add(view);
		frame.add(lpan);

		frame.setVisible(true);

	}

	// / Set location list that is used to populate the ComboBox Labels

	/**
	 * @param locations
	 *            Gets
	 */
	public void setLocationsList(String[] locations) {
		this.locations = locations;
	}

}
