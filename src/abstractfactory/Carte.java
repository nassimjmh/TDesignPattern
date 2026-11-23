package abstractfactory;

/** Logique du jeu : aucune dépendance vers la représentation graphique. */
public class Carte {
	private final String nom;

	public Carte(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}
}
