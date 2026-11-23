package decorator;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/** ConcreteComponent : la carte officielle de base (fond + nom). */
public class CarteGraphiquePikachu implements CarteGraphique {
	private final Carte carte = new Carte("Pikachu");

	@Override
	public Carte getCarte() {
		return carte;
	}

	@Override
	public BufferedImage genererImage(int l, int h) {
		BufferedImage img = new BufferedImage(l, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = (Graphics2D) img.getGraphics();
		g.setColor(new Color(255, 221, 0));
		g.fillRect(0, 0, l, h);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.BOLD, 14));
		g.drawString(carte.getNom(), 10, 20);
		g.dispose();
		return img;
	}
}
