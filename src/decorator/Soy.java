package decorator;


public class Soy extends CondimentDecorator {

	public Soy(Beverage b) {
		super(b);
	}

	@Override
	public double getPrice() {
		return this.decorated.getPrice() + 0.4;
	}

	@Override
	public String toString() {
		return this.decorated + ", soja";
	}
	
}
