package observateur;

import observateur.SeasonCycle.Season;

public class Main {
	public static void main(String[] args) {
		SeasonCycle cycle = new SeasonCycle(); // démarre en HIVER
		Bee maya = new Bee();
		HummingBird flit = new HummingBird();

		System.out.println(">>> FLEURS <<<");
		for (Season s : Season.values()) {
			Flower f = new Flower(s);
			System.out.println(f);
			cycle.addPropertyChangeListener(f); // la fleur observe le cycle des saisons
			f.addPropertyChangeListener(maya); // les pollinisateurs observent la fleur
			f.addPropertyChangeListener(flit);
		}

		for (int i = 0; i < 4; i++) {
			System.out.println(">>> " + Season.values()[(cycle.getSeason().ordinal() + 1) % 4] + " <<<");
			cycle.next();
		}

		System.out.println("\n=== Rattrapage : l'Anneau Unique, l'Oeil de Sauron et les Nazgûls ===");
		MainRattrapage.main(args);
	}
}
