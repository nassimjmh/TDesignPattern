package abstractfactory.maze.door;

import abstractfactory.maze.room.Room;

public class MagicDoor extends Door {

	public MagicDoor(Room room1, Room room2, boolean isOpen) {
		super(room1, room2, isOpen);
	}

	public MagicDoor(Room room1, Room room2) {
		this(room1, room2, true);
	}
	
	public String toString() {
		return "magic" + super.toString();
	}
	
}
