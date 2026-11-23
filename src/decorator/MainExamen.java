package decorator;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class MainExamen {
	public static void main(String[] args) {
		// Q9(d) : une carte graphique Pikachu collector ET paralysée
		CarteGraphique carte = new CarteGraphiquePikachu();
		carte = new NumeroSerie(carte, 42, 500); // collector
		carte = new FiltreCouleur(carte, new Color(128, 128, 128, 120)); // gris translucide = paralysé

		BufferedImage img = carte.genererImage(200, 280);
		System.out.println("Carte " + carte.getCarte().getNom() + " collector + paralysée : image "
				+ img.getWidth() + "x" + img.getHeight()
				+ ", pixel(100,140) = 0x" + Integer.toHexString(img.getRGB(100, 140)));
	}
}
