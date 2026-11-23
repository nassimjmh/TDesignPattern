package factory;

import factory.game.BombedMazeCreator;
import factory.game.EnchantedMazeCreator;
import factory.game.MazeGameCreator;
import factory.game.SimpleMazeGame;

public class Main {
	public static void main(String[] args) {
		System.out.println("=== Sans pattern : SimpleMazeGame (code dupliqué pour chaque variante) ===");
		SimpleMazeGame simple = new SimpleMazeGame();
		System.out.println(simple.createMaze());
		System.out.println(simple.createEnchantedMaze());
		System.out.println(simple.createBombedMaze());

		System.out.println("=== Méthode de fabrique : create() est écrit une seule fois ===");
		MazeGameCreator game = new MazeGameCreator();
		System.out.println("Simple maze using factory methods");
		System.out.println(game.create());

		game = new EnchantedMazeCreator();
		System.out.println("Enchanted maze using factory methods");
		System.out.println(game.create());

		game = new BombedMazeCreator();
		System.out.println("Bombed maze using factory methods");
		System.out.println(game.create());

	}
}
