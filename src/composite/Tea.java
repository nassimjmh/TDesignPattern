package composite;

public class Tea extends Beverage {

	@Override
	public double getPrice() {
		return 3.15;
	}

	@Override
	public String toString() {
		return "thé";
	}

}
