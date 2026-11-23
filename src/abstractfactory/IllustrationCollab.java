package abstractfactory;

import java.awt.Color;
import java.awt.Graphics2D;

/** ConcreteProduct (version collab McDo). */
public class IllustrationCollab implements Illustration {
	private final String sujet;

	public IllustrationCollab(String sujet) {
		this.sujet = sujet;
	}

	@Override
	public void dessiner(Graphics2D g, int l, int h) {
		g.setColor(new Color(230, 30, 30));
		g.fillRect(0, 0, l, h);
		g.setColor(Color.BLACK);
		g.drawString(sujet + " (collab McDo)", 10, 20);
	}

	@Override
	public String getVersion() {
		return "collab McDo";
	}
}
