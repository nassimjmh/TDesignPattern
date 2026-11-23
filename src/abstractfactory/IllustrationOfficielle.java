package abstractfactory;

import java.awt.Color;
import java.awt.Graphics2D;

/** ConcreteProduct (version officielle). */
public class IllustrationOfficielle implements Illustration {
	private final String sujet;

	public IllustrationOfficielle(String sujet) {
		this.sujet = sujet;
	}

	@Override
	public void dessiner(Graphics2D g, int l, int h) {
		g.setColor(new Color(255, 221, 0));
		g.fillRect(0, 0, l, h);
		g.setColor(Color.BLACK);
		g.drawString(sujet + " (officielle)", 10, 20);
	}

	@Override
	public String getVersion() {
		return "officielle";
	}
}
