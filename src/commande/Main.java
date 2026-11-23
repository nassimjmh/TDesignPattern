package commande;


public class Main {
	public static void main(String[] args) {
		if (args.length > 0 && args[0].equals("interactif")) {
			// Simulateur du corrigé (menu au clavier) : obtenir 4L avec un bidon de 3L et un de 5L
			new Simulator(new Can[] { new Can(3), new Can(5) }, 4).start();
			return;
		}

		Can[] cans = { new Can(3), new Can(5) };
		Invoker invoker = new Invoker();

		System.out.println("Obtenir 4L avec un bidon de 3L et un bidon de 5L :");
		Command[] sequence = {
				new FillCommand(cans[1]), // 5L : 0/3 5/5
				new DecantCommand(cans[1], cans[0]), // 3/3 2/5
				new EmptyCommand(cans[0]), // 0/3 2/5
				new DecantCommand(cans[1], cans[0]), // 2/3 0/5
				new FillCommand(cans[1]), // 2/3 5/5
				new DecantCommand(cans[1], cans[0]) // 3/3 4/5 -> gagné
		};
		for (Command c : sequence) {
			invoker.pushCommand(c);
			System.out.println(c + "\n   -> " + cans[0] + " | " + cans[1]);
		}

		System.out.println("\nAnnulation de la dernière action (undo) :");
		invoker.popLastCommand();
		System.out.println(cans[0] + " | " + cans[1]);
		System.out.println("\n(lancer avec l'argument 'interactif' pour le simulateur au clavier)");
	}
}
