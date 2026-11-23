package decorator.beverage;

public class Chocolate extends Beverage {

	@Override
	public double getPrice() {
		return 3.55;
	}

	@Override
	public String toString() {
		return "chocolat";
	}

}
