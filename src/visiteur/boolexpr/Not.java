package visiteur.boolexpr;

/** ConcreteElement. */
public class Not extends UnaryOperator {
	public Not(Node operand) {
		super(operand);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}
