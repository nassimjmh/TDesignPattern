package visiteur.batiment;

/** ConcreteVisitor : calcule les taxes. */
public class Fisc implements Visiteur {
	@Override
	public void visiterMaison(Maison m) {
		System.out.println("Fisc : maison " + m.getAdresse() + " -> taxe fonciere " + (m.getSurface() * 2) + " EUR");
	}

	@Override
	public void visiterImmeuble(Immeuble i) {
		System.out.println("Fisc : immeuble " + i.getAdresse() + " -> taxe fonciere " + (i.getNbLots() * 80) + " EUR");
	}

	@Override
	public void visiterUsine(Usine u) {
		System.out.println("Fisc : usine " + u.getNom() + " -> taxe professionnelle " + (u.getChiffreAffaires() / 50)
				+ " kEUR");
	}
}
