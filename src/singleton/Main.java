package singleton;

import singleton.logging.LoggerEager;
import singleton.logging.LoggerLazy;
import singleton.logging.LoggerMultiton;

public class Main {
	public static void main(String[] args) {
		System.out.println("=== TD1 : Logger en Singleton ===");
		System.out.println("Eager instanciation");
		LoggerEager.getInstance().log("Hello!");
		LoggerEager.getInstance().log("Bye.");
		System.out.println("Meme instance ? " + (LoggerEager.getInstance() == LoggerEager.getInstance()));

		System.out.println("\nLazy instanciation");
		LoggerLazy.getInstance().log("Hello!");
		LoggerLazy.getInstance().log("Bye.");
		System.out.println("Meme instance ? " + (LoggerLazy.getInstance() == LoggerLazy.getInstance()));

		System.out.println("\nMultiton (une instance par clé)");
		LoggerMultiton.getInstance("info").log("Hello!");
		LoggerMultiton.getInstance("err").log("Bug...");
		LoggerMultiton.getInstance("info").log("Bye."); // LOG2 : même instance que le premier "info"

	}
}
