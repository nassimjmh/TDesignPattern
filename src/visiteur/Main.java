package visiteur;

import visiteur.batiment.Assureur;
import visiteur.batiment.Fisc;
import visiteur.batiment.Immeuble;
import visiteur.batiment.Maison;
import visiteur.batiment.Pompier;
import visiteur.batiment.Quartier;
import visiteur.batiment.Usine;
import visiteur.boolexp.And;
import visiteur.boolexp.Bool;
import visiteur.boolexp.Node;
import visiteur.boolexp.Not;
import visiteur.boolexp.Or;
import visiteur.boolexp.visitor.DisplayVisitor;
import visiteur.boolexp.visitor.EvalVisitor;

public class Main {
	private static void show(Node expr) {
		expr.accept(new DisplayVisitor());
		EvalVisitor evaluator = new EvalVisitor();
		expr.accept(evaluator);
		System.out.println(" = " + evaluator.getValue());
	}

	public static void main(String[] args) {
		System.out.println("=== Corrigé TD6 : expressions booléennes (affichage et évaluation) ===");
		// ((true Or false) And (Not true)) = false (exemple de l'énoncé)
		show(new And(new Or(new Bool(true), new Bool(false)), new Not(new Bool(true))));
		show(new Or(new Bool(false), new Not(new Bool(false))));
		show(new Not(new And(new Bool(true), new Bool(true))));
		show(new Bool(true));

		System.out.println("\n=== Exemple : des agents visitent un quartier ===");
		Quartier quartier = new Quartier();
		quartier.ajouter(new Maison("12 rue des Lilas", 90, true));
		quartier.ajouter(new Immeuble("3 avenue Foch", 24, 6));
		quartier.ajouter(new Usine("Metalex", 4, 5000));
		quartier.ajouter(new Maison("8 impasse du Lac", 140, false));

		Assureur assureur = new Assureur();
		quartier.accept(assureur);
		System.out.println("Total des primes : " + assureur.getTotalPrimes() + " EUR\n");
		quartier.accept(new Pompier());
		System.out.println();
		quartier.accept(new Fisc()); // nouvel agent : aucun bâtiment n'a été modifié
	}
}
