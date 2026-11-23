package factory;

public class EnchantedRoom extends Room {

	public EnchantedRoom(int number) {
		super(number);
	}
	
	public String toString() {
		return "enchanted " + super.toString();
	}

}
