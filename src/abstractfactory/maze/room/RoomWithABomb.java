package abstractfactory.maze.room;

public class RoomWithABomb extends Room {

	public RoomWithABomb(int number) {
		super(number);
	}
	
	public String toString() {
		return "bombed " + super.toString();
	}
	
}
