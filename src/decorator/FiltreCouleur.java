package decorator;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/** ConcreteDecorator : applique un filtre coloré translucide (violet = empoisonné, gris = paralysé). */
public class FiltreCouleur extends DecorateurCarte {
	private final Color couleur;

	public FiltreCouleur(CarteGraphique c, Color couleur) {
		super(c);
		this.couleur = couleur;
	}

	@Override
	public BufferedImage genererImage(int l, int h) {
		BufferedImage img = super.genererImage(l, h);
		Graphics2D g = (Graphics2D) img.getGraphics();
		g.setColor(couleur);
		g.fillRect(0, 0, l, h);
		g.dispose();
		return img;
	}
}
