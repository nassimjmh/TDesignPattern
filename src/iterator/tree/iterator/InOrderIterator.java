package iterator.tree.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

import iterator.tree.Tree;

public class InOrderIterator<V> implements Iterator<V> {

	private Tree<V> current;

	public InOrderIterator(Tree<V> t) {
		current = leftmost(t);
	}

	@Override
	public boolean hasNext() {
		return current != null;
	}

	@Override
	public V next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		V v = current.getValue();
		if (current.getRight() != null) {
			current = leftmost(current.getRight());
		} else {
			while (current.getParent() != null
					&& current == current.getParent().getRight()) {
				current = current.getParent();
			}
			current = current.getParent();
		}
		return v;
	}

	public static <V> Tree<V> leftmost(Tree<V> t) {
		while (t.getLeft() != null) {
			t = t.getLeft();
		}
		return t;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
