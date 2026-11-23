package observateur;


public class Bee extends PollinatingAnimal {

	@Override
	public void gatherPollen(Flower flower) {
		System.out.println("L'abeille butine une " + flower + ".");
	}

}
