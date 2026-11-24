package iterator;

import java.util.Iterator;

import iterator.exemple.InfixIterator;
import iterator.exemple.PostfixIterator;
import iterator.exemple.PrefixIterator;
import iterator.exemple.Playlist;
import iterator.tree.Tree;

public class Main {
	private static <V> void afficher(String nom, Iterator<V> it) {
		StringBuilder sb = new StringBuilder(nom + " :");
		while (it.hasNext()) {
			sb.append(" ").append(it.next());
		}
		System.out.println(sb);
	}

	public static void main(String[] args) {
		System.out.println("=== Exemple : une collection Iterable (boucle for-each) ===");
		Playlist p = new Playlist().ajouter("Intro").ajouter("Refrain").ajouter("Outro");
		for (String titre : p) { // le for-each appelle iterator(), hasNext() et next()
			System.out.println("- " + titre);
		}

		System.out.println("\n=== Exemple : trois itérateurs sur un arbre binaire ===");
		//         4
		//       /   \
		//      2     6
		//     / \   / \
		//    1   3 5   7
		Tree<Integer> arbre = new Tree<>(4,
				new Tree<>(2, new Tree<>(1), new Tree<>(3)),
				new Tree<>(6, new Tree<>(5), new Tree<>(7)));
		afficher("Infixe  (attendu 1 2 3 4 5 6 7)", new InfixIterator<>(arbre));
		afficher("Prefixe (attendu 4 2 1 3 6 5 7)", new PrefixIterator<>(arbre));
		afficher("Postfixe(attendu 1 3 2 5 7 6 4)", new PostfixIterator<>(arbre));

		// arbre non complet : noeuds avec un seul enfant
		Tree<Integer> arbre2 = new Tree<>(1, null, new Tree<>(2, new Tree<>(3), null));
		afficher("Arbre déséquilibré, infixe  (attendu 1 3 2)", new InfixIterator<>(arbre2));
		afficher("Arbre déséquilibré, prefixe (attendu 1 2 3)", new PrefixIterator<>(arbre2));
		afficher("Arbre déséquilibré, postfixe(attendu 3 2 1)", new PostfixIterator<>(arbre2));
	}
}
