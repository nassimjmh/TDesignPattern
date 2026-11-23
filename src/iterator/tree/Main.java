package iterator.tree;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        //         4
        //       /   \
        //      2     6
        //     / \   / \
        //    1   3 5   7
        Tree<Integer> tree = new Tree<>(4,
                new Tree<>(2, new Tree<>(1), new Tree<>(3)),
                new Tree<>(6, new Tree<>(5), new Tree<>(7)));

        test("Infixe", tree, Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        test("Prefixe", tree, Arrays.asList(4, 2, 1, 3, 6, 5, 7));
        test("Suffixe", tree, Arrays.asList(1, 3, 2, 5, 7, 6, 4));
    }

    /**
     * Teste la classe du même package (constructeur(Tree), parcours(Tree),
     * champ privé "list") par réflexion : Main compile même si la classe
     * n'existe pas encore.
     */
    private static void test(String className, Tree<Integer> tree, List<Integer> expected) {
        System.out.println("=== " + className + " ===");
        try {
            Class<?> c = Class.forName("iterator.tree." + className);
            Object o = c.getConstructor(Tree.class).newInstance(tree);
            Method m = c.getMethod("parcours", Tree.class);
            m.invoke(o, tree);

            Field f = c.getDeclaredField("list");
            f.setAccessible(true);
            List<?> result = (List<?>) f.get(o);

            System.out.println("Attendu : " + expected);
            System.out.println("Obtenu  : " + result);
            System.out.println(expected.equals(result) ? "OK" : "KO");
        } catch (ClassNotFoundException e) {
            System.out.println("Classe pas encore créée, ignoré");
        } catch (Exception e) {
            System.out.println("Erreur : " + e);
        }
    }
}
