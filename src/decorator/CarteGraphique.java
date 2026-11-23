package decorator;

import java.awt.image.BufferedImage;

/** Component : une carte que l'on peut rendre sous forme d'image. */
public interface CarteGraphique {
	Carte getCarte();

	BufferedImage genererImage(int l, int h);
}
