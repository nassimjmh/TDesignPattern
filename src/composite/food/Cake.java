package composite.food;

public class Cake extends Food {

	@Override
	public double getPrice() {
		return 2.25;
	}
	
	@Override
	public String toString() {
		return "cake";
	}

}
