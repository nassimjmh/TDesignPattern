package adapter.priority;

import java.util.TreeSet;

/**
 * Adaptateur d'objet : adapte un ensemble d'entiers trié (Adaptee)
 * à l'interface PriorityQueue (Target).
 * Limite : un ensemble ignore les doublons, donc add(3) deux fois ne compte qu'une fois.
 */
public class SetPriorityQueueAdapter implements PriorityQueue {

	private final TreeSet<Integer> set;

	public SetPriorityQueueAdapter(TreeSet<Integer> set) {
		this.set = set;
	}

	@Override
	public void add(Object o) {
		set.add((Integer) o);
	}

	@Override
	public int size() {
		return set.size();
	}

	@Override
	public Object removeSmallest() {
		return set.pollFirst(); // null si vide
	}
}
