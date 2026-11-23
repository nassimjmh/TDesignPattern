package decorator;

import java.util.LinkedList;
import java.util.List;

public class OrderComposite extends Order {

	private List<Order> children;

	public OrderComposite() {
		this.children = new LinkedList<Order>();
	}

	@Override
	public void add(Order o) {
		children.add(o);
	}

	@Override
	public void remove(Order o) {
		children.remove(o);
	}

	@Override
	public Order getChild(int i) {
		return children.get(i);
	}

	@Override
	public double getPrice() {
		double sum = 0;
		for (Order o : children) {
			sum += o.getPrice();
		}
		return sum;
	}

	@Override
	protected void print() {
		for (Order o : children) {
			o.print();
		}
	}

}
