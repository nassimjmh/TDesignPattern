package abstractfactory;

import java.awt.Color;
import java.awt.Graphics2D;

/** ConcreteProduct (version fan-art). */
public class IllustrationFanArt implements Illustration {
	private final String sujet;

	public IllustrationFanArt(String sujet) {
		this.sujet = sujet;
	}

	@Override
	public void dessiner(Graphics2D g, int l, int h) {
		g.setColor(new Color(200, 120, 255));
		g.fillRect(0, 0, l, h);
		g.setColor(Color.BLACK);
		g.drawString(sujet + " (fan-art)", 10, 20);
	}

	@Override
	public String getVersion() {
		return "fan-art";
	}
}
