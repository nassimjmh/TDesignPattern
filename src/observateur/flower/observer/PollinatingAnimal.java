package observateur.flower.observer;

import observateur.flower.Flower;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public abstract class PollinatingAnimal implements PropertyChangeListener {

	public abstract void gatherPollen(Flower flower);

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		Flower flower = (Flower) evt.getSource();
		if (flower.isBlooming()) {
			this.gatherPollen(flower);
		}
	}

}
