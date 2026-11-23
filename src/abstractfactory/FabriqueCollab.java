package abstractfactory;

/** ConcreteFactory : toutes les illustrations produites sont de la version collab McDo. */
public class FabriqueCollab implements FabriqueIllustrations {
	@Override
	public Illustration creerIllustrationPikachu() {
		return new IllustrationCollab("Pikachu");
	}

	@Override
	public Illustration creerIllustrationEnergieElectrique() {
		return new IllustrationCollab("Energie Electrique");
	}
}
