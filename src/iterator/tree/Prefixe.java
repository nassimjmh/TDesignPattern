package iterator.tree;

import java.util.ArrayList;

public class Prefixe {
    private Tree<Integer> tree;
    private ArrayList<Integer> list = new ArrayList<>();

    public Prefixe(Tree tree){
        this.tree = tree;
    }

    public void parcours(Tree<Integer> tree) {
        if (tree.getLeft()==null && tree.getRight()==null){
            list.add(tree.getValue());
        }
        if (tree.getLeft()!=null){
            list.add(tree.getValue());
            parcours(tree.getLeft());
        }
        if (tree.getRight()!=null){
            parcours(tree.getRight());
        }

    }

}
