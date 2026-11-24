package visiteur.boolexpr;

/** ConcreteVisitor : construit la représentation textuelle (le résultat s'accumule dans le visiteur). */
public class PrintVisitor implements Visitor {
	private final StringBuilder sb = new StringBuilder();

	public String getResult() {
		return sb.toString();
	}

	@Override
	public void visit(Bool b) {
		sb.append(b.getValue());
	}

	@Override
	public void visit(And a) {
		sb.append("(");
		a.getLeftOperand().accept(this);
		sb.append(" And ");
		a.getRightOperand().accept(this);
		sb.append(")");
	}

	@Override
	public void visit(Or o) {
		sb.append("(");
		o.getLeftOperand().accept(this);
		sb.append(" Or ");
		o.getRightOperand().accept(this);
		sb.append(")");
	}

	@Override
	public void visit(Not n) {
		sb.append("(Not ");
		n.getOperand().accept(this);
		sb.append(")");
	}
}
