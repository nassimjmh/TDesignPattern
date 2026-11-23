package factory;

/** Product : classe abstraite de toutes les armes. */
public abstract class Arme {
	private int puissance;

	protected Arme(int puissance) {
		this.puissance = puissance;
	}

	public int getPuissance() {
		return puissance;
	}

	public void addPuissance(int x) {
		puissance += x;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " (puissance " + puissance + ")";
	}
}
