package iterator.tree;

import java.util.LinkedList;
import java.util.List;

import iterator.tree.Tree.Order;

public class Main {

	private static <V> void iterate(Tree<V> t) {
		System.out.print("Parcours " + t.getOrder() + " : ");
		for (V v : t) {
			System.out.print(v + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Tree<Integer> t1 = new Tree<Integer>(2, new Tree<Integer>(1, null, null), new Tree<Integer>(3, null, null));
		Tree<Integer> t2 = new Tree<Integer>(4,
				new Tree<Integer>(1, null, new Tree<Integer>(2, null, new Tree<Integer>(3, null, null))),
				new Tree<Integer>(8,
						new Tree<Integer>(6, new Tree<Integer>(5, null, null), new Tree<Integer>(7, null, null)),
						null));
		Tree<Integer> t3 = new Tree<Integer>(1, new Tree<Integer>(2, new Tree<Integer>(3, null, null), null), null);
		List<Tree<Integer>> trees = new LinkedList<>();
		trees.add(t1);
		trees.add(t2);
		trees.add(t3);
		for (Tree<Integer> t : trees) {
			iterate(t);
			t.setOrder(Order.PREFIXE);
			iterate(t);
			t.setOrder(Order.POSTFIXE);
			iterate(t);
		}
	}
}
