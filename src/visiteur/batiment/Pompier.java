package visiteur.batiment;

/** ConcreteVisitor : contrôle la sécurité incendie. */
public class Pompier implements Visiteur {
	@Override
	public void visiterMaison(Maison m) {
		System.out.println("Pompier : maison " + m.getAdresse() + " -> "
				+ (m.aDetecteurFumee() ? "conforme" : "detecteur de fumee manquant"));
	}

	@Override
	public void visiterImmeuble(Immeuble i) {
		System.out.println("Pompier : immeuble " + i.getAdresse() + " -> "
				+ (i.getNbEtages() > 4 ? "colonne seche obligatoire" : "controle standard"));
	}

	@Override
	public void visiterUsine(Usine u) {
		System.out.println("Pompier : usine " + u.getNom() + " -> "
				+ (u.getNiveauRisque() >= 4 ? "plan d'evacuation et sprinklers exiges" : "controle standard"));
	}
}
