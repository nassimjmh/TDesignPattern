package visiteur.batiment;

/** Element : un bâtiment accepte la visite d'un agent. */
public interface Batiment {
	void accept(Visiteur v);
}
