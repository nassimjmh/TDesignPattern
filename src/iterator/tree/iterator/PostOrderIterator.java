package iterator.tree.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

import iterator.tree.Tree;

public class PostOrderIterator<V> implements Iterator<V> {

	private Tree<V> current;

	public PostOrderIterator(Tree<V> t) {
		current = firstleaf(t);
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
		if (current.getParent() == null) {
			current = null;
		} else {
			if (current.getParent().getLeft() == current && current.getParent().getRight() != null) {
				current = firstleaf(current.getParent().getRight());
			} else {
				current = current.getParent();
			}
		}
		return v;
	}

	public static <V> Tree<V> firstleaf(Tree<V> t) {
		while ((t.getLeft() != null) || (t.getRight() != null)) {
			if (t.getLeft() != null) {
				t = t.getLeft();
			} else {
				t = t.getRight();
			}
		}
		return t;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
