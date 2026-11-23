package observateur;


public class HummingBird extends PollinatingAnimal {

	@Override
	public void gatherPollen(Flower flower) {
		System.out.println("Le colibri butine une " + flower + ".");
	}

}
