package composite.beverage;

public class Coffee extends Beverage {

	@Override
	public double getPrice() {
		return 1.75;
	}

	@Override
	public String toString() {
		return "café";
	}

}
