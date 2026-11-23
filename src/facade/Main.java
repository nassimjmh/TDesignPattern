package facade;

public class Main {
	public static void main(String[] args) {
		System.out.println("=== Sans façade (le client manipule tous les composants) ===");
		ClientNotUsingFacade c1 = new ClientNotUsingFacade();
		c1.activateSecuritySystem();
		System.out.println("--");
		c1.deactivateSecuritySystem();

		System.out.println("\n=== Avec façade (activate / deactivate) ===");
		SecurityFacade securite = new ClientUsingFacade().getSecuritySystem();
		securite.activate();
		System.out.println("--");
		securite.deactivate();
	}
}
