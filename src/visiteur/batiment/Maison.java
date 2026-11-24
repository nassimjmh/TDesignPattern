package visiteur.batiment;

public class Maison implements Batiment {
	private final String adresse;
	private final int surface;
	private final boolean detecteurFumee;

	public Maison(String adresse, int surface, boolean detecteurFumee) {
		this.adresse = adresse;
		this.surface = surface;
		this.detecteurFumee = detecteurFumee;
	}

	public String getAdresse() {
		return adresse;
	}

	public int getSurface() {
		return surface;
	}

	public boolean aDetecteurFumee() {
		return detecteurFumee;
	}

	@Override
	public void accept(Visiteur v) {
		v.visiterMaison(this); // ici this EST une Maison : le type est connu à la compilation
	}
}
