package decorator;


public abstract class CondimentDecorator extends Beverage {

	protected Beverage decorated;

	public CondimentDecorator(Beverage b) {
		this.decorated = b;
	}

}
