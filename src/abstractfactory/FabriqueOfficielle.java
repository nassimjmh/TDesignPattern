package abstractfactory;

/** ConcreteFactory : toutes les illustrations produites sont de la version officielle. */
public class FabriqueOfficielle implements FabriqueIllustrations {
	@Override
	public Illustration creerIllustrationPikachu() {
		return new IllustrationOfficielle("Pikachu");
	}

	@Override
	public Illustration creerIllustrationEnergieElectrique() {
		return new IllustrationOfficielle("Energie Electrique");
	}
}
