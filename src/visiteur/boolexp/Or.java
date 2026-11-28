package visiteur.boolexp;

import visiteur.boolexp.visitor.Visitor;

public class Or extends BinaryOperator {

	public Or(Node leftOperand, Node rightOperand) {
		super(leftOperand, rightOperand);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
