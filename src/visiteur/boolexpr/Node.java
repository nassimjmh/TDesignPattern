package visiteur.boolexpr;

/** Element : tout noeud de l'expression accepte un visiteur. */
public interface Node {
	void accept(Visitor v);
}
