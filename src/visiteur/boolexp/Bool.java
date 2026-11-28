package visiteur.boolexp;

import visiteur.boolexp.visitor.Visitor;

public class Bool implements Node {

	private boolean value;

	public Bool(boolean value) {
		this.value = value;
	}

	public boolean getValue() {
		return value;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
