package composite;

import composite.beverage.Chocolate;
import composite.beverage.Coffee;
import composite.food.Cake;
import composite.food.Muffin;
import composite.order.Menu;
import composite.order.Order;
import composite.order.OrderComposite;

public class Main {
	public static void main(String[] args) {
		Order simpleOrder = new Cake();
		System.out.println("Commande simple :");
		simpleOrder.total();

		// menu (chocolat + muffin) + 2 cafés
		Order compositeOrder = new OrderComposite();
		compositeOrder.add(new Menu(new Chocolate(), new Muffin()));
		compositeOrder.add(new Coffee());
		compositeOrder.add(new Coffee());
		System.out.println("\nCommande composite :");
		compositeOrder.total(); // attendu : 5.22 / 1.75 / 1.75 / Total 8.72
	}
}
