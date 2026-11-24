package visiteur.batiment;

/** ConcreteVisitor : calcule les primes d'assurance (le total est l'état accumulé du visiteur). */
public class Assureur implements Visiteur {
	private int totalPrimes = 0;

	public int getTotalPrimes() {
		return totalPrimes;
	}

	@Override
	public void visiterMaison(Maison m) {
		int prime = m.getSurface() * 3;
		totalPrimes += prime;
		System.out.println("Assureur : maison " + m.getAdresse() + " -> prime " + prime + " EUR (selon la surface)");
	}

	@Override
	public void visiterImmeuble(Immeuble i) {
		int prime = i.getNbLots() * 120;
		totalPrimes += prime;
		System.out.println("Assureur : immeuble " + i.getAdresse() + " -> prime " + prime + " EUR (par lot)");
	}

	@Override
	public void visiterUsine(Usine u) {
		int prime = u.getNiveauRisque() * 1000;
		totalPrimes += prime;
		System.out.println("Assureur : usine " + u.getNom() + " -> prime " + prime + " EUR (risque industriel)");
	}
}
