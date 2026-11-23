package facade;

public class ClientUsingFacade {

	private SecurityFacade securitySystem;

	public ClientUsingFacade() {
		this.securitySystem = new SecurityFacade(20, 11, 22, 17);
	}

	public SecurityFacade getSecuritySystem() {
		return this.securitySystem;
	}

	public static void main(String[] args) {
		new ClientUsingFacade().getSecuritySystem().activate();
	}
}
