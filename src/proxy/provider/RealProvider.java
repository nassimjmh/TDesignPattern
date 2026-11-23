package proxy.provider;

public class RealProvider implements Provider {

	@Override
	public void service1() {
		System.out.println("Service 1 utilisé.");
	}

	@Override
	public void service2() {
		System.out.println("Service 2 utilisé.");
	}

	@Override
	public void service3() {
		System.out.println("Service 3 utilisé.");
	}

	@Override
	public void service4() {
		System.out.println("Service 4 utilisé.");
	}

}
