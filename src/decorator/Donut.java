package decorator;

public class Donut extends Food {

	@Override
	public double getPrice() {
		return 2.00;
	}
	
	@Override
	public String toString() {
		return "donut";
	}

}
