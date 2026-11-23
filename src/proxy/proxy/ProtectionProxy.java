package proxy.proxy;

import proxy.provider.Provider;
import java.util.Scanner;

public class ProtectionProxy implements Provider {

	private Provider provider;
	private String password;
	private static final Scanner sc = new Scanner(System.in);

	public ProtectionProxy(Provider provider, String password) {
		this.provider = provider;
		this.password = password;
	}

	@Override
	public void service1() {
		this.provider.service1();
	}

	@Override
	public void service2() {
		this.provider.service2();
	}

	@Override
	public void service3() {
		if (authorizedAccess()) {
			this.provider.service3();
		} else {
			System.out.println("Service 3 non autorisé à utiliser.");
		}
	}

	@Override
	public void service4() {
		if (authorizedAccess()) {
			this.provider.service4();
		} else {
			System.out.println("Service 4 non autorisé à utiliser.");
		}
	}

	private boolean authorizedAccess() {
		boolean ok = false;
		System.out.println("Mot de passe : ");
		if (sc.nextLine().equals(this.password)) {
			ok = true;
		} else {
			System.out.println("Mot de passe invalide !");
		}
		// sc.close();
		return ok;
	}

}
