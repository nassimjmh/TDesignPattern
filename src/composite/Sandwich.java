package composite;

public class Sandwich extends Food {

	@Override
	public double getPrice() {
		return 5.45;
	}
	
	@Override
	public String toString() {
		return "sandwich";
	}

}
