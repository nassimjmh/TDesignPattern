package proxy;


public class InvoiceProxy implements Provider {

	private Provider provider;

	private int[] nbUses;

	private double[] costsOfServices;

	public InvoiceProxy() {
		this.provider = new RealProvider();
		this.nbUses = new int[] { 0, 0, 0, 0 };
		this.costsOfServices = new double[] { 11, 20, 22, 17 };
	}

	@Override
	public void service1() {
		this.provider.service1();
		nbUses[0]++;
	}

	@Override
	public void service2() {
		this.provider.service2();
		nbUses[1]++;
	}

	@Override
	public void service3() {
		this.provider.service3();
		nbUses[2]++;
	}

	@Override
	public void service4() {
		this.provider.service4();
		nbUses[3]++;
	}

	public double totalCost() {
		double total = 0;
		for (int i = 0; i < 4; i++) {
			total += nbUses[i] * costsOfServices[i];
		}
		return total;
	}

}
