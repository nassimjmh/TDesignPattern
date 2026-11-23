package commande;

import java.util.Iterator;
import java.util.Stack;


public class Invoker implements Iterable<Command> {

	private Stack<Command> history;

	public Invoker() {
		this.history = new Stack<Command>();
	}

	/**
	 * Execute la commande et la sauvegarde dans l'historique
	 */
	public void pushCommand(Command c) {
		c.execute();
		history.push(c);
	}

	/**
	 * Annule la commande la plus récente et la retire de l'historique
	 */
	public void popLastCommand() {
		if (!history.empty()) {
			history.lastElement().cancel();
			history.pop();
		} else {
			System.err.println("Retour en arrière impossible.");
		}
	}

	@Override
	public Iterator<Command> iterator() {
		return history.iterator();
	}

}
