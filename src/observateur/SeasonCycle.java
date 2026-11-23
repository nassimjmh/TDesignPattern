package observateur;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class SeasonCycle {

	public static enum Season {
		PRINTEMPS, ETE, AUTOMNE, HIVER
	};

	private Season season;
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	public SeasonCycle(Season season) {
		this.season = season;
	}

	public SeasonCycle() {
		this(Season.HIVER);
	}

	public Season getSeason() {
		return this.season;
	}

	public void next() {
		Season oldSeason = season;
		season = Season.values()[(season.ordinal() + 1) % 4];
		pcs.firePropertyChange("season", oldSeason, season);
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}
}
