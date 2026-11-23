package composite;

public class Espresso extends Beverage {

	@Override
	public double getPrice() {
		return 2.75;
	}

	@Override
	public String toString() {
		return "expresso";
	}

}
