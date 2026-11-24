package iterator.exemple;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

import iterator.tree.Tree;

/** ConcreteIterator : parcours préfixe (racine, gauche, droite). */
public class PrefixIterator<V> implements Iterator<V> {
	private final Deque<Tree<V>> pile = new ArrayDeque<>();

	public PrefixIterator(Tree<V> racine) {
		if (racine != null) {
			pile.push(racine);
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
		if (n.getRight() != null) {
			pile.push(n.getRight()); // droite d'abord, pour que la gauche sorte la première
		}
		if (n.getLeft() != null) {
			pile.push(n.getLeft());
		}
		return n.getValue();
	}
}
