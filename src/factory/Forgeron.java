package factory;

/**
 * Creator. interagir() joue le rôle de anOperation() : il appelle la méthode de fabrique
 * creerArme() que chaque sous-classe redéfinit. Ajouter une nouvelle arme = ajouter une arme
 * et un forgeron, sans modifier ni dupliquer le code existant.
 */
public abstract class Forgeron {
	protected abstract Arme creerArme(); // factory method

	public void interagir(Personnage p) {
		Arme arme = creerArme();
		arme.addPuissance(5); // le forgeron augmente la puissance
		p.setArme(arme);
	}
}
