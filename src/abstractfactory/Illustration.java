package abstractfactory;

import java.awt.Graphics2D;

/** Abstract product : l'illustration d'une carte (dépend de la version : officielle, fan-art...). */
public interface Illustration {
	void dessiner(Graphics2D g, int l, int h);

	String getVersion();
}
