package abstractfactory;

/**
 * AbstractFactory : une méthode par produit de la famille. Une fabrique concrète ne produit que
 * des illustrations d'une même version, donc le deck reste cohérent.
 */
public interface FabriqueIllustrations {
	Illustration creerIllustrationPikachu();

	Illustration creerIllustrationEnergieElectrique();
}
