package commande;

import java.util.Scanner;


public class Simulator {

	private final Can[] cans;
	private int desiredVolume;

	private static Scanner sc = new Scanner(System.in);

	public Simulator(Can[] cans, int desiredVolume) {
		this.cans = cans;
		this.desiredVolume = desiredVolume;
	}

	private Can chooseCan() {
		int choice;
		do {
			for (int i = 0; i < cans.length; i++)
				System.out.println((i + 1) + ". " + cans[i]);
			choice = sc.nextInt();
		} while (choice < 1 || choice > cans.length);
		return cans[choice - 1];
	}

	public void start() {
		while (true) {
			int choice;
			do {
				System.out.println("1. Remplir un bidon");
				System.out.println("2. Vider un bidon");
				System.out.println("3. Transvaser un bidon dans un autre");
				System.out.println("4. Annuler la dernière action");
				System.out.println("5. Quitter");
				choice = sc.nextInt();
			} while (choice < 1 || choice > 5);
			switch (choice) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					return;
			}
			for (Can c : cans) {
				System.out.println(c);
			}
			for (Can c : cans) {
				if (c.getVolume() == desiredVolume) {
					System.out.println("Gagné !");
					return;
				}
			}
		}
	}

	public static void main(String[] args) {
		Can[] cans = { new Can(3), new Can(5) };
		new Simulator(cans, 4).start();
	}
}