package adapter.priority;

/** Interface cible (Target) attendue par le client. */
public interface PriorityQueue {
	void add(Object o);

	int size();

	Object removeSmallest();
}
