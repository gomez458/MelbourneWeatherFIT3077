package obsPattern;

import java.util.*;

public class TwentyUpdater implements Subject {
	private boolean started = false;

	HashSet<Observer> Observers = new HashSet<Observer>();

	@Override
	public void attach(Observer o) {
		if (started == false) {
			startClock();
			started = true;

		}

		Observers.add(o);
	}

	@Override
	public void detach(Observer o) {

		Observers.remove(o);
	}

	/*
	 * Notify All Locations.
	 */
	@Override
	public void notifyObservers() {

		for (Observer o : Observers) {
			;
			o.update();

		}
	}

	/**
	 * Start 20second timer and event scheduler 
	 */
	public void startClock() {
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			@Override
			public void run() {

				notifyObservers();// Calls update to all
			}

		}, 0, 20000);
	}
}
