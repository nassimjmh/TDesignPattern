package abstractfactory;

/** ConcreteFactory : toutes les illustrations produites sont de la version fan-art. */
public class FabriqueFanArt implements FabriqueIllustrations {
	@Override
	public Illustration creerIllustrationPikachu() {
		return new IllustrationFanArt("Pikachu");
	}

	@Override
	public Illustration creerIllustrationEnergieElectrique() {
		return new IllustrationFanArt("Energie Electrique");
	}
}
