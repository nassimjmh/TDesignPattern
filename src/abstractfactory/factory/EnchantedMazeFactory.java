package abstractfactory.factory;

import abstractfactory.maze.door.Door;
import abstractfactory.maze.door.MagicDoor;
import abstractfactory.maze.room.EnchantedRoom;
import abstractfactory.maze.room.Room;

public class EnchantedMazeFactory extends MazeFactory {

	@Override
	public Room makeRoom(int number) {
		return new EnchantedRoom(number);
	}

	@Override
	public Door makeDoor(Room room1, Room room2) {
		return new MagicDoor(room1, room2);
	}

}
