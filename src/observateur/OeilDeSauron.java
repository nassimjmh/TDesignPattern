package observateur;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/** Observeur : devient rouge et regarde le porteur quand l'anneau est passé au doigt. */
public class OeilDeSauron implements PropertyChangeListener {
	private boolean estRouge = false;

	public boolean estRouge() {
		return estRouge;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		AnneauUnique anneau = (AnneauUnique) evt.getSource();
		estRouge = anneau.estPorte();
		if (estRouge) {
			System.out.println("L'Oeil de Sauron devient rouge et regarde " + anneau.getPorteur().getNom() + ".");
		} else {
			System.out.println("L'Oeil de Sauron retrouve sa couleur normale.");
		}
	}
}
