package factory;


public class BombedMazeCreator extends MazeGameCreator {

	public Room makeRoom(int number) { 
		return new RoomWithABomb(number);
	}
	
	public Wall makeWall() { 
		return new BombedWall();
	}
	
}
