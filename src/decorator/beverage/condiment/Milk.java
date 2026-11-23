package decorator.beverage.condiment;

import decorator.beverage.Beverage;

public class Milk extends CondimentDecorator {

	public Milk(Beverage b) {
		super(b);
	}

	@Override
	public double getPrice() {
		return this.decorated.getPrice() + 0.2;
	}

	@Override
	public String toString() {
		return this.decorated + ", lait";
	}
	
}
