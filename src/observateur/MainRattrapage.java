package observateur;

public class MainRattrapage {
	public static void main(String[] args) {
		AnneauUnique anneau = new AnneauUnique();
		OeilDeSauron oeil = new OeilDeSauron();
		Nazgul roi = new Nazgul("Roi-Sorcier");

		anneau.addPropertyChangeListener(oeil);
		anneau.addPropertyChangeListener(roi);

		// Q5(d) : Frodon passe l'anneau à son doigt
		anneau.setPorteur(new Personnage("Frodon"));
		anneau.porter();
		anneau.retirer();
	}
}
