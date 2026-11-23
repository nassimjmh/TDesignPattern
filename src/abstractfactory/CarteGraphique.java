package abstractfactory;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * Une seule classe : lie la logique (Carte) à une Illustration. Aucune duplication quand on ajoute
 * une nouvelle version de cartes : il suffit d'ajouter une fabrique et ses illustrations.
 */
public class CarteGraphique {
	private final Carte carte;
	private final Illustration illustration;

	public CarteGraphique(Carte carte, Illustration illustration) {
		this.carte = carte;
		this.illustration = illustration;
	}

	public Carte getCarte() {
		return carte;
	}

	public Illustration getIllustration() {
		return illustration;
	}

	public BufferedImage genererImage(int l, int h) {
		BufferedImage img = new BufferedImage(l, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = (Graphics2D) img.getGraphics();
		illustration.dessiner(g, l, h);
		g.dispose();
		return img;
	}

	@Override
	public String toString() {
		return carte.getNom() + " [" + illustration.getVersion() + "]";
	}
}
