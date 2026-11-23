package singleton;

public class Hobbit implements Personnage {
	private final String nom;

	public Hobbit(String nom) {
		this.nom = nom;
	}

	@Override
	public String getNom() {
		return nom;
	}
}
