package iterator.tree.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

import iterator.tree.Tree;

public class PreOrderIterator<V> implements Iterator<V> {

	private Tree<V> current;

	public PreOrderIterator(Tree<V> t) {
		current = t;
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
		if (current.getLeft() != null) {
			current = current.getLeft();
		} else if (current.getRight() != null) {
			current = current.getRight();
		} else {
			while (true) {
				while (current.getParent() != null
						&& current == current.getParent().getRight()) {
					current = current.getParent();
				}
				current = current.getParent();
				if (current == null) {
					break;
				}
				if (current.getRight() != null) {
					current = current.getRight();
					break;
				}
			}
		}
		return v;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
