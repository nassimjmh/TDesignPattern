package decorator;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/** ConcreteDecorator : inscrit un numéro de série (collector, édition limitée). */
public class NumeroSerie extends DecorateurCarte {
	private final int numero;
	private final int total;

	public NumeroSerie(CarteGraphique c, int numero, int total) {
		super(c);
		this.numero = numero;
		this.total = total;
	}

	@Override
	public BufferedImage genererImage(int l, int h) {
		BufferedImage img = super.genererImage(l, h); // d'abord ce qui est déjà décoré
		Graphics2D g = (Graphics2D) img.getGraphics();
		g.setColor(Color.RED);
		g.setFont(new Font("Arial", Font.ITALIC, 10));
		g.drawString("N° " + numero + "/" + total, 10, h - 10);
		g.dispose();
		return img;
	}
}
