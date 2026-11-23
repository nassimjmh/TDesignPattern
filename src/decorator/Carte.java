package decorator;

/** Classe métier (logique du jeu), indépendante de la représentation graphique. */
public class Carte {
	private final String nom;

	public Carte(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}
}
