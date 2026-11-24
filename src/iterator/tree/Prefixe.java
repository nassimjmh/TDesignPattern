package iterator.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Prefixe implements Iterator<Integer> {
    private Tree<Integer> tree;
    private ArrayList<Integer> list = new ArrayList<>();
    private int index = 0;

    public Prefixe(Tree tree){
        this.tree = tree;
    }

    public void parcours(Tree<Integer> tree) {
        list.add(tree.getValue());
        if (tree.getLeft()!=null){
            parcours(tree.getLeft());
        }
        if (tree.getRight()!=null){
            parcours(tree.getRight());
        }
    }

    // Remplit la liste au premier appel (si parcours() n'a pas déjà été lancé)
    private void init() {
        if (list.isEmpty() && tree != null) {
            parcours(tree);
        }
    }

    @Override
    public boolean hasNext() {
        init();
        return index < list.size();
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return list.get(index++);
    }
}
