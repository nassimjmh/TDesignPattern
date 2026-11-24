package adapter.stack;

/** Interface cible (Target) attendue par le client. */
public interface Stack {
	void push(Object o);

	Object pop();

	Object top();
}
