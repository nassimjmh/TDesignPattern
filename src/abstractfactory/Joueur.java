package abstractfactory;

import java.util.ArrayList;
import java.util.List;

public class Joueur {
	private final String nom;
	private final List<CarteGraphique> deck = new ArrayList<>();

	public Joueur(String nom) {
		this.nom = nom;
	}

	public void ajouterCarteAuDeck(CarteGraphique c) {
		deck.add(c);
	}

	@Override
	public String toString() {
		return nom + " : " + deck;
	}
}
