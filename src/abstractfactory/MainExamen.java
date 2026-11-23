package abstractfactory;

public class MainExamen {
	/** Le client ne connaît que FabriqueIllustrations, jamais les classes concrètes. */
	static Joueur composerDeck(String nom, FabriqueIllustrations fabrique) {
		Joueur j = new Joueur(nom);
		j.ajouterCarteAuDeck(new CarteGraphique(new Carte("Pikachu"), fabrique.creerIllustrationPikachu()));
		j.ajouterCarteAuDeck(new CarteGraphique(new Carte("Energie Electrique"),
				fabrique.creerIllustrationEnergieElectrique()));
		return j;
	}

	public static void main(String[] args) {
		// Q10(d) : jouer avec les cartes officielles (les deux joueurs ont la même version)
		System.out.println(composerDeck("Sacha", new FabriqueOfficielle()));
		System.out.println(composerDeck("Ondine", new FabriqueOfficielle()));
		// d'autres versions, sans rien modifier d'autre
		System.out.println(composerDeck("Fan", new FabriqueFanArt()));
		System.out.println(composerDeck("Gourmand", new FabriqueCollab()));
	}
}
