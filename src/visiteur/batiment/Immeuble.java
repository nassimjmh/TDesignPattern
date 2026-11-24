package visiteur.batiment;

public class Immeuble implements Batiment {
	private final String adresse;
	private final int nbLots;
	private final int nbEtages;

	public Immeuble(String adresse, int nbLots, int nbEtages) {
		this.adresse = adresse;
		this.nbLots = nbLots;
		this.nbEtages = nbEtages;
	}

	public String getAdresse() {
		return adresse;
	}

	public int getNbLots() {
		return nbLots;
	}

	public int getNbEtages() {
		return nbEtages;
	}

	@Override
	public void accept(Visiteur v) {
		v.visiterImmeuble(this);
	}
}
