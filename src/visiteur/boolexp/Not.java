package visiteur.boolexp;

import visiteur.boolexp.visitor.Visitor;

public class Not extends UnaryOperator {

	public Not(Node operand) {
		super(operand);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
