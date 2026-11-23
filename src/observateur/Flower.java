package observateur;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import observateur.SeasonCycle.Season;

public class Flower implements PropertyChangeListener {
	private boolean isBlooming;
	private Season season;
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	public Flower(Season season) {
		this.isBlooming = false;
		this.season = season;
	}

	public boolean isBlooming() {
		return this.isBlooming;
	}

	public void bloom() {
		this.isBlooming = true;
		pcs.firePropertyChange("isBlooming", false, true);
	}

	public Season getSeason() {
		return this.season;
	}

	@Override
	public String toString() {
		return "fleur fleurissant durant la saison " + this.getSeason();
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (this.getSeason().equals(evt.getNewValue()) && !isBlooming()) {
			this.bloom();
		}
	}
}
