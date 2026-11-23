package singleton;

public class MainRattrapage {
	public static void main(String[] args) {
		// Q4(b) : donner l'Anneau Unique à Bilbon et le lui faire passer au doigt
		Hobbit bilbon = new Hobbit("Bilbon");
		AnneauUnique.getInstance().setPorteur(bilbon);
		AnneauUnique.getInstance().porter();

		System.out.println("Une seule instance ? "
				+ (AnneauUnique.getInstance() == AnneauUnique.getInstance()));
	}
}
