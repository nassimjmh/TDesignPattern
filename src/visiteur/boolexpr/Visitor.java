package visiteur.boolexpr;

/** Visitor : une méthode visit() par classe concrète d'élément. */
public interface Visitor {
	void visit(Bool b);

	void visit(And a);

	void visit(Or o);

	void visit(Not n);
}
