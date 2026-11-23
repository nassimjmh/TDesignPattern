package decorator;

import decorator.beverage.Chocolate;
import decorator.beverage.Coffee;
import decorator.beverage.condiment.Milk;
import decorator.beverage.condiment.Mocha;
import decorator.beverage.condiment.Soy;
import decorator.food.Muffin;
import decorator.order.Menu;
import decorator.order.Order;
import decorator.order.OrderComposite;

public class Main {
	public static void main(String[] args) {
		// menu + café avec double dose de moka + café avec soja et lait
		Order order = new OrderComposite();
		order.add(new Menu(new Chocolate(), new Muffin()));
		order.add(new Mocha(new Mocha(new Coffee())));
		order.add(new Milk(new Soy(new Coffee())));
		System.out.println("Commande avec condiments :");
		order.total(); // attendu : 5.22 / 2.35 / 2.35 / Total 9.92

	}
}
