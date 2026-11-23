package decorator;


public class Whip extends CondimentDecorator {

	public Whip(Beverage b) {
		super(b);
	}

	@Override
	public double getPrice() {
		return this.decorated.getPrice() + 0.5;
	}

	@Override
	public String toString() {
		return this.decorated + ", crème";
	}

}
