package visiteur.boolexp.visitor;

import visiteur.boolexp.And;
import visiteur.boolexp.Bool;
import visiteur.boolexp.Not;
import visiteur.boolexp.Or;

public interface Visitor {

	public void visit(Bool n);

	public void visit(Or n);

	public void visit(And n);

	public void visit(Not n);
}
