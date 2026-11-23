package factory;

/** ConcreteCreator : ne sait forger qu'un seul type d'arme. */
public class ForgeronHache extends Forgeron {
	@Override
	protected Arme creerArme() {
		return new Hache();
	}
}
