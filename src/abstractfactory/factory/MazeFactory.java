package abstractfactory.factory;

import abstractfactory.maze.Maze;
import abstractfactory.maze.door.Door;
import abstractfactory.maze.room.Room;
import abstractfactory.maze.wall.Wall;

public class MazeFactory {

	public Maze makeMaze() {
		return new Maze();
	}

	public Room makeRoom(int number) {
		return new Room(number);
	}

	public Wall makeWall() {
		return new Wall();
	}

	public Door makeDoor(Room room1, Room room2) {
		return new Door(room1, room2);
	}

}
