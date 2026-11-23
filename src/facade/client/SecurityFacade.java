package facade.client;

import facade.security.Alarm;
import facade.security.Camera;
import facade.security.Light;
import facade.security.Sensor;
import java.util.ArrayList;
import java.util.List;

public class SecurityFacade {

	private List<Sensor> sensors;
	private List<Alarm> alarms;
	private List<Camera> cameras;
	private List<Light> lights;

	public SecurityFacade(int nbSensors, int nbAlarms, int nbCameras, int nbLights) {
		this.sensors = new ArrayList<>(nbSensors);
		for (int i = 0; i < nbSensors; i++) {
			this.sensors.add(new Sensor());
		}
		this.alarms = new ArrayList<>(nbAlarms);
		for (int i = 0; i < nbAlarms; i++) {
			this.alarms.add(new Alarm());
		}
		this.cameras = new ArrayList<>(nbCameras);
		for (int i = 0; i < nbCameras; i++) {
			this.cameras.add(new Camera());
		}
		this.lights = new ArrayList<>(nbLights);
		for (int i = 0; i < nbLights; i++) {
			this.lights.add(new Light());
		}
	}

	public void activate() {
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

	public void deactivate() {
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

}
