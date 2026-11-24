package iterator.exemple;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

import iterator.tree.Tree;

/** ConcreteIterator : parcours infixe (gauche, racine, droite) avec une pile explicite. */
public class InfixIterator<V> implements Iterator<V> {
	private final Deque<Tree<V>> pile = new ArrayDeque<>();

	public InfixIterator(Tree<V> racine) {
		empilerGauche(racine);
	}

	private void empilerGauche(Tree<V> n) {
		while (n != null) {
			pile.push(n);
			n = n.getLeft();
		}
	}

	@Override
	public boolean hasNext() {
		return !pile.isEmpty();
	}

	@Override
	public V next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		Tree<V> n = pile.pop();
		empilerGauche(n.getRight());
		return n.getValue();
	}
}
