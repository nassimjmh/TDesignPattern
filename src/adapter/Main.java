package adapter;

import adapter.adapter.EnumerationAdapter;
import adapter.priority.PriorityQueue;
import adapter.priority.SetPriorityQueueAdapter;
import adapter.stack.ListStackAdapter;
import adapter.stack.Stack;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
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

		System.out.println("\nListe doublement chainee -> Stack :");
		Stack s = new ListStackAdapter(new LinkedList<>());
		s.push("a");
		s.push("b");
		s.push("c");
		System.out.println("top = " + s.top());
		System.out.println("pop = " + s.pop());
		System.out.println("pop = " + s.pop());
		System.out.println("top = " + s.top());

		System.out.println("\nEnsemble d'entiers -> PriorityQueue :");
		PriorityQueue q = new SetPriorityQueueAdapter(new TreeSet<>());
		q.add(5);
		q.add(1);
		q.add(8);
		q.add(3);
		System.out.println("size = " + q.size());
		System.out.println("removeSmallest = " + q.removeSmallest());
		System.out.println("removeSmallest = " + q.removeSmallest());
		System.out.println("size = " + q.size());
	}
}
