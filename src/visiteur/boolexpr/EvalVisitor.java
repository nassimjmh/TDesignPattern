package visiteur.boolexpr;

/** ConcreteVisitor : évalue l'expression, le résultat intermédiaire est l'état du visiteur. */
public class EvalVisitor implements Visitor {
	private boolean result;

	public boolean getResult() {
		return result;
	}

	@Override
	public void visit(Bool b) {
		result = b.getValue();
	}

	@Override
	public void visit(And a) {
		a.getLeftOperand().accept(this);
		boolean left = result;
		a.getRightOperand().accept(this);
		result = left && result;
	}

	@Override
	public void visit(Or o) {
		o.getLeftOperand().accept(this);
		boolean left = result;
		o.getRightOperand().accept(this);
		result = left || result;
	}

	@Override
	public void visit(Not n) {
		n.getOperand().accept(this);
		result = !result;
	}
}
