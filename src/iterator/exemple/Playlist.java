package iterator.exemple;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * ConcreteAggregate : une collection de titres. iterator() est la méthode de fabrique d'Iterable
 * (pattern Méthode de fabrique) ; la structure interne (une liste) reste cachée au client.
 */
public class Playlist implements Iterable<String> {
	private final List<String> titres = new ArrayList<>();

	public Playlist ajouter(String titre) {
		titres.add(titre);
		return this;
	}

	@Override
	public Iterator<String> iterator() {
		return new PlaylistIterator();
	}

	/** ConcreteIterator : classe interne, accès privilégié à la collection. */
	private class PlaylistIterator implements Iterator<String> {
		private int courant = 0;

		@Override
		public boolean hasNext() {
			return courant < titres.size();
		}

		@Override
		public String next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return titres.get(courant++);
		}
	}
}
