package visiteur.batiment;

public class Usine implements Batiment {
	private final String nom;
	private final int niveauRisque; // 1 (faible) à 5 (élevé)
	private final int chiffreAffaires; // en milliers d'euros

	public Usine(String nom, int niveauRisque, int chiffreAffaires) {
		this.nom = nom;
		this.niveauRisque = niveauRisque;
		this.chiffreAffaires = chiffreAffaires;
	}

	public String getNom() {
		return nom;
	}

	public int getNiveauRisque() {
		return niveauRisque;
	}

	public int getChiffreAffaires() {
		return chiffreAffaires;
	}

	@Override
	public void accept(Visiteur v) {
		v.visiterUsine(this);
	}
}
