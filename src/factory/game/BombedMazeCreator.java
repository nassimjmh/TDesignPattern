package factory.game;

import factory.maze.room.Room;
import factory.maze.room.RoomWithABomb;
import factory.maze.wall.BombedWall;
import factory.maze.wall.Wall;

public class BombedMazeCreator extends MazeGameCreator {

	public Room makeRoom(int number) { 
		return new RoomWithABomb(number);
	}
	
	public Wall makeWall() { 
		return new BombedWall();
	}
	
}
