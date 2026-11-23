package facade;

import java.util.ArrayList;
import java.util.List;


public class ClientNotUsingFacade {

	private List<Sensor> sensors;
	private List<Alarm> alarms;
	private List<Camera> cameras;
	private List<Light> lights;

	public ClientNotUsingFacade() {
		this.sensors = new ArrayList<>(5);
		for (int i = 0; i < 5; i++) {
			this.sensors.add(new Sensor());
		}
		this.alarms = new ArrayList<>(1);
		for (int i = 0; i < 1; i++) {
			this.alarms.add(new Alarm());
		}
		this.cameras = new ArrayList<>(2);
		for (int i = 0; i < 2; i++) {
			this.cameras.add(new Camera());
		}
		this.lights = new ArrayList<>(3);
		for (int i = 0; i < 3; i++) {
			this.lights.add(new Light());
		}
	}

	public void activateSecuritySystem() {
		for (Sensor s : this.sensors) {
			s.activate();
		}
		for (Alarm a : this.alarms) {
			a.activate();
		}
		for (Camera c : this.cameras) {
			c.turnOn();
			c.rotate();
		}
		for (Light l : this.lights) {
			l.turnOff();
		}
	}

	public void deactivateSecuritySystem() {
		for (Sensor s : this.sensors) {
			s.deactivate();
		}
		for (Alarm a : this.alarms) {
			a.stopRing();
		}
		for (Camera c : this.cameras) {
			c.turnOff();
		}
	}

	public static void main(String[] args) {
		new ClientNotUsingFacade().activateSecuritySystem();
	}

}
