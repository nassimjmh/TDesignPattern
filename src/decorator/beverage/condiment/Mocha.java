package decorator.beverage.condiment;

import decorator.beverage.Beverage;

public class Mocha extends CondimentDecorator {

	public Mocha(Beverage b) {
		super(b);
	}

	@Override
	public double getPrice() {
		return this.decorated.getPrice() + 0.3;
	}

	@Override
	public String toString() {
		return this.decorated + ", moka";
	}
	
}
