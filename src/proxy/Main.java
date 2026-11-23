package proxy;

import proxy.provider.Provider;
import proxy.provider.RealProvider;
import proxy.proxy.InvoiceProxy;
import proxy.proxy.ProtectionProxy;

public class Main {
	private static void run(Provider p) {
		p.service1();
		p.service2();
		p.service1();
		p.service4();
		p.service3();
	}

	public static void main(String[] args) {
		System.out.println("=== Proxy facture ===");
		InvoiceProxy invoiceProxy = new InvoiceProxy();
		run(invoiceProxy);
		System.out.println("Coût total : " + invoiceProxy.totalCost());

		System.out.println("\n=== Proxy de protection (mdp = 1234) pour les services 3 et 4 ===");
		System.out.println("(le mot de passe est demandé sur l'entrée standard)");
		run(new ProtectionProxy(new RealProvider(), "1234"));

		System.out.println("\n=== Proxy facture + protection (mdp = 0000) : proxys chaînés ===");
		invoiceProxy = new InvoiceProxy();
		run(new ProtectionProxy(invoiceProxy, "0000"));
		System.out.println("Coût total : " + invoiceProxy.totalCost());
	}
}
