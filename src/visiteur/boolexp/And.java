package visiteur.boolexp;

import visiteur.boolexp.visitor.Visitor;

public class And extends BinaryOperator {

	public And(Node leftOperand, Node rightOperand) {
		super(leftOperand, rightOperand);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}
