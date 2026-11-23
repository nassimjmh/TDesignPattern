package abstractfactory;

public class RoomWithABomb extends Room {

	public RoomWithABomb(int number) {
		super(number);
	}
	
	public String toString() {
		return "bombed " + super.toString();
	}
	
}
