package visiteur.boolexpr;

public abstract class UnaryOperator implements Operator {

	protected Node operand;

	public UnaryOperator(Node operand) {
		this.operand = operand;
	}

	public Node getOperand() {
		return operand;
	}

}
