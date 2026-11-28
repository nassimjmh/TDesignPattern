package visiteur.boolexp.visitor;

import visiteur.boolexp.And;
import visiteur.boolexp.Bool;
import visiteur.boolexp.Not;
import visiteur.boolexp.Or;

public class EvalVisitor implements Visitor {

	private boolean value;

	public boolean getValue() {
		return value;
	}

	@Override
	public void visit(Bool n) {
		value = n.getValue();
	}

	@Override
	public void visit(Not n) {
		n.getOperand().accept(this);
		value = !value;
	}

	@Override
	public void visit(And n) {
		n.getLeftOperand().accept(this);
		boolean left = value;
		n.getRightOperand().accept(this);
		value = left && value;
	}

	@Override
	public void visit(Or n) {
		n.getLeftOperand().accept(this);
		boolean left = value;
		n.getRightOperand().accept(this);
		value = left || value;
	}

}
