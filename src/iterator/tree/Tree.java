package iterator.tree;

import java.util.Iterator;

import iterator.tree.iterator.InOrderIterator;
import iterator.tree.iterator.PostOrderIterator;
import iterator.tree.iterator.PreOrderIterator;

public class Tree<V> implements Iterable<V> {

	public enum Order {
		PREFIXE, INFIXE, POSTFIXE
	};

	private Tree<V> left, right, parent;
	private V value;
	private Order order;

	public Tree(V value, Tree<V> left, Tree<V> right) {
		this.value = value;
		this.left = left;
		this.right = right;
		this.parent = null;
		if (this.left != null) {
			this.left.parent = this;
		}
		if (this.right != null) {
			this.right.parent = this;
		}
		this.order = Order.INFIXE;
	}

	public Tree(V value) {
		this(value, null, null);
	}

	public Tree<V> getLeft() {
		return this.left;
	}

	public Tree<V> getRight() {
		return this.right;
	}

	public Tree<V> getParent() {
		return this.parent;
	}

	public V getValue() {
		return this.value;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order o) {
		this.order = o;
	}

	@Override
	public Iterator<V> iterator() {
		Iterator<V> it = null;
		switch (this.order) {
		case PREFIXE:
			it = new PreOrderIterator<V>(this);
			break;
		case INFIXE:
			it = new InOrderIterator<V>(this);
			break;
		case POSTFIXE:
			it = new PostOrderIterator<V>(this);
			break;
		}
		return it;
	}

}
