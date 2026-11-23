package observateur.flower.observer;

import observateur.flower.Flower;

public class HummingBird extends PollinatingAnimal {

	@Override
	public void gatherPollen(Flower flower) {
		System.out.println("Le colibri butine une " + flower + ".");
	}

}
