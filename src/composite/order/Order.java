package composite.order;

public abstract class Order {

	public abstract double getPrice();

	protected void print() {
		System.out.println("- " + this + " : " + format(this.getPrice()));
	}

	public void total() {
		this.print();
		System.out.println("Total : " + format(this.getPrice()));
	}

	private static String format(double price) {
		return String.format(java.util.Locale.US, "%.2f", price);
	}

	public void add(Order o) {
	}

	public void remove(Order o) {
	}

	public Order getChild(int i) {
		return null;
	}

}
