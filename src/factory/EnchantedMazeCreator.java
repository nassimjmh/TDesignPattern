package factory;


public class EnchantedMazeCreator extends MazeGameCreator {

	public Room makeRoom(int number) {
		return new EnchantedRoom(number);
	}

	public Door makeDoor(Room room1, Room room2) {
		return new MagicDoor(room1, room2);
	}

}
