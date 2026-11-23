package decorator;

import java.awt.image.BufferedImage;

/**
 * Decorator : implémente la même interface que le composant décoré et contient UNE référence
 * vers un CarteGraphique (multiplicité 1). Les effets se combinent en s'empilant.
 */
public abstract class DecorateurCarte implements CarteGraphique {
	protected final CarteGraphique carteDecoree;

	protected DecorateurCarte(CarteGraphique carteDecoree) {
		this.carteDecoree = carteDecoree;
	}

	@Override
	public Carte getCarte() {
		return carteDecoree.getCarte();
	}

	@Override
	public BufferedImage genererImage(int l, int h) {
		return carteDecoree.genererImage(l, h);
	}
}
