package decorator;

public class Cookie extends Food {

	@Override
	public double getPrice() {
		return 1.95;
	}
	
	@Override
	public String toString() {
		return "cookie";
	}

}
