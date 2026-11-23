package observateur;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/** Observeur : avance vers le porteur de l'anneau. */
public class Nazgul implements PropertyChangeListener {
	private final String nom;

	public Nazgul(String nom) {
		this.nom = nom;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		AnneauUnique anneau = (AnneauUnique) evt.getSource();
		if (anneau.estPorte()) {
			System.out.println("Le Nazgul " + nom + " avance vers " + anneau.getPorteur().getNom() + ".");
		}
	}
}
