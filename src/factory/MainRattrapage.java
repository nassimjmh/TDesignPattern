package factory;

public class MainRattrapage {
	public static void main(String[] args) {
		Personnage aragorn = new Personnage("Aragorn");
		Personnage legolas = new Personnage("Legolas");
		Personnage gimli = new Personnage("Gimli");

		new ForgeronEpee().interagir(aragorn);
		new ForgeronArc().interagir(legolas);
		new ForgeronHache().interagir(gimli);

		System.out.println(aragorn);
		System.out.println(legolas);
		System.out.println(gimli);
	}
}
