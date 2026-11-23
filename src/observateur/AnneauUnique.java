package observateur;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Observable (Subject). Il ne connaît que des PropertyChangeListener : le couplage avec
 * l'Oeil de Sauron, les Nazgûls, les graphismes ou la musique est minimal.
 */
public class AnneauUnique {
	private boolean estPorte = false;
	private Personnage porteur;
	private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	public void addPropertyChangeListener(PropertyChangeListener l) {
		pcs.addPropertyChangeListener(l);
	}

	public void removePropertyChangeListener(PropertyChangeListener l) {
		pcs.removePropertyChangeListener(l);
	}

	public Personnage getPorteur() {
		return porteur;
	}

	public void setPorteur(Personnage porteur) {
		this.porteur = porteur;
	}

	public boolean estPorte() {
		return estPorte;
	}

	public void porter() {
		if (porteur == null) {
			throw new IllegalStateException("L'anneau n'a pas de porteur");
		}
		boolean ancien = estPorte;
		estPorte = true;
		pcs.firePropertyChange("estPorte", ancien, estPorte); // notifier()
	}

	public void retirer() {
		if (porteur == null) {
			throw new IllegalStateException("L'anneau n'a pas de porteur");
		}
		boolean ancien = estPorte;
		estPorte = false;
		pcs.firePropertyChange("estPorte", ancien, estPorte);
	}
}
