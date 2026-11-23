package abstractfactory;


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
