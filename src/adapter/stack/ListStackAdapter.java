package adapter.stack;

import java.util.LinkedList;

/**
 * Adaptateur d'objet : adapte une liste doublement chaînée (Adaptee)
 * à l'interface Stack (Target). Le sommet de la pile est la tête de liste.
 */
public class ListStackAdapter implements Stack {

	private final LinkedList<Object> list;

	public ListStackAdapter(LinkedList<Object> list) {
		this.list = list;
	}

	@Override
	public void push(Object o) {
		list.addFirst(o);
	}

	@Override
	public Object pop() {
		return list.removeFirst(); // NoSuchElementException si pile vide
	}

	@Override
	public Object top() {
		return list.getFirst();
	}
}
