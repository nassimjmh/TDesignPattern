package visiteur.boolexpr;

/** ConcreteElement : une constante booléenne (feuille). */
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
		v.visit(this); // double dispatch : ici, this est statiquement un Bool
	}
}
