package adapter;

import adapter.adapter.EnumerationAdapter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Main {
	/** Le client attend un Iterator (interface cible). */
	public static void print(Iterator<Object> it) {
		Object o;
		while (it.hasNext()) {
			if ((o = it.next()) instanceof String) {
				System.out.println(o);
			}
		}
	}

	public static void main(String[] args) {
		List<Object> l = new LinkedList<>();
		l.add("Foo");
		l.add(Integer.valueOf(22));
		l.add(Double.valueOf(17.5));
		l.add("Bar");
		l.add(Boolean.TRUE);

		System.out.println("Appel de print avec un Iterator :");
		print(l.iterator());

		System.out.println("\nAppel de print avec un adaptateur Enumeration -> Iterator :");
		Vector<Object> v = new Vector<>(l);
		print(new EnumerationAdapter(v.elements()));
	}
}
