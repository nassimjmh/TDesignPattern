package visiteur.batiment;

/**
 * Visitor : une méthode par type de bâtiment. Si on ajoute un Entrepot, il faut ajouter
 * visiterEntrepot ici : le compilateur signale alors chaque agent à mettre à jour.
 */
public interface Visiteur {
	void visiterMaison(Maison m);

	void visiterImmeuble(Immeuble i);

	void visiterUsine(Usine u);
}
