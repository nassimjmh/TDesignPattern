package singleton;

/**
 * Rattrapage Q4(a) : AnneauUnique en Singleton (instanciation eager, thread-safe).
 * - constructeur privé
 * - attribut statique de son propre type
 * - getInstance() statique = point d'accès global
 */
public class AnneauUnique {
	private static final AnneauUnique INSTANCE = new AnneauUnique();

	private boolean estPorte = false;
	private Personnage porteur;

	private AnneauUnique() {
	}

	public static AnneauUnique getInstance() {
		return INSTANCE;
	}

	public Personnage getPorteur() {
		return porteur;
	}

	public void setPorteur(Personnage porteur) {
		this.porteur = porteur;
	}

	public void porter() {
		if (porteur == null) {
			throw new IllegalStateException("L'anneau n'a pas de porteur");
		}
		estPorte = true;
		System.out.println(porteur.getNom() + " passe l'Anneau Unique à son doigt.");
	}

	public void retirer() {
		if (porteur == null) {
			throw new IllegalStateException("L'anneau n'a pas de porteur");
		}
		estPorte = false;
		System.out.println(porteur.getNom() + " retire l'Anneau Unique.");
	}

	public boolean estPorte() {
		return estPorte;
	}
}
