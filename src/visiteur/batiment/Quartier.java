package visiteur.batiment;

import java.util.ArrayList;
import java.util.List;

/** ObjectStructure : énumère ses éléments et leur présente le visiteur. */
public class Quartier {
	private final List<Batiment> batiments = new ArrayList<>();

	public void ajouter(Batiment b) {
		batiments.add(b);
	}

	public void accept(Visiteur v) {
		for (Batiment b : batiments) {
			b.accept(v); // le type statique est Batiment : seul accept() peut dispatcher
		}
	}
}
