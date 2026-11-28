package visiteur.boolexp;

import visiteur.boolexp.visitor.Visitor;

public interface Node {

	public void accept(Visitor v);

}
