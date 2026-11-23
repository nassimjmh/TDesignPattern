package composite.food;

public class Muffin extends Food {

	@Override
	public double getPrice() {
		return 2.25;
	}
	
	@Override
	public String toString() {
		return "muffin";
	}

}
