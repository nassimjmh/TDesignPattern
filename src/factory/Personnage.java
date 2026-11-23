package factory;

public class Personnage {
	private final String nom;
	private Arme arme;

	public Personnage(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public Arme getArme() {
		return arme;
	}

	/** Remplace l'ancienne arme si le personnage en possédait une. */
	public void setArme(Arme arme) {
		this.arme = arme;
	}

	@Override
	public String toString() {
		return nom + " -> " + arme;
	}
}
