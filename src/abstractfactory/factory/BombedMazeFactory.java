package abstractfactory.factory;

import abstractfactory.maze.room.Room;
import abstractfactory.maze.room.RoomWithABomb;
import abstractfactory.maze.wall.BombedWall;
import abstractfactory.maze.wall.Wall;

public class BombedMazeFactory extends MazeFactory {
	
	@Override
	public Room makeRoom(int number) { 
		return new RoomWithABomb(number);
	}
	
	@Override
	public Wall makeWall() { 
		return new BombedWall();
	}
	
}
