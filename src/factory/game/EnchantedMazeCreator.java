package factory.game;

import factory.maze.door.Door;
import factory.maze.door.MagicDoor;
import factory.maze.room.EnchantedRoom;
import factory.maze.room.Room;

public class EnchantedMazeCreator extends MazeGameCreator {

	public Room makeRoom(int number) {
		return new EnchantedRoom(number);
	}

	public Door makeDoor(Room room1, Room room2) {
		return new MagicDoor(room1, room2);
	}

}
