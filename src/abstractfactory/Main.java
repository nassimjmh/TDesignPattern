package abstractfactory;

public class Main {
	public static void main(String[] args) {
		System.out.println("Simple maze using a factory");
		System.out.println(MazeGameAbstractFactory.create(new MazeFactory()));

		System.out.println("Enchanted maze using a factory");
		System.out.println(MazeGameAbstractFactory.create(new EnchantedMazeFactory()));

		System.out.println("Bombed maze using a factory");
		System.out.println(MazeGameAbstractFactory.create(new BombedMazeFactory()));

		System.out.println("=== Examen : decks de cartes cohérents (officielles / fan-art / collab) ===");
		MainExamen.main(args);
	}
}
