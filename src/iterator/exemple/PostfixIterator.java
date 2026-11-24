package iterator.exemple;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

import iterator.tree.Tree;

/** ConcreteIterator : parcours postfixe (gauche, droite, racine). */
public class PostfixIterator<V> implements Iterator<V> {
	private final Deque<Tree<V>> pile = new ArrayDeque<>();

	public PostfixIterator(Tree<V> racine) {
		descendre(racine);
	}

	/** Empile le chemin jusqu'à la première feuille (gauche si possible, sinon droite). */
	private void descendre(Tree<V> n) {
		while (n != null) {
			pile.push(n);
			n = (n.getLeft() != null) ? n.getLeft() : n.getRight();
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
		if (!pile.isEmpty()) {
			Tree<V> parent = pile.peek();
			if (parent.getLeft() == n && parent.getRight() != null) {
				descendre(parent.getRight()); // on vient de finir la gauche : il reste la droite
			}
		}
		return n.getValue();
	}
}
