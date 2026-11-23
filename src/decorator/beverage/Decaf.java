package decorator.beverage;

public class Decaf extends Beverage {

	@Override
	public double getPrice() {
		return 2.50;
	}

	@Override
	public String toString() {
		return "décaféiné";
	}

}
