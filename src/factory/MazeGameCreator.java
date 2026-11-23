package factory;

import factory.Room.Direction;


public class MazeGameCreator {

	public Maze create() {
		Maze maze = makeMaze();
		Room room1 = makeRoom(1);
		Room room2 = makeRoom(2);
		Door door = makeDoor(room1, room2);

		maze.addRoom(room1);
		room1.setSide(Direction.NORTH, makeWall());
		room1.setSide(Direction.EAST, door);
		room1.setSide(Direction.SOUTH, makeWall());
		room1.setSide(Direction.WEST, makeWall());

		maze.addRoom(room2);
		room2.setSide(Direction.NORTH, makeWall());
		room2.setSide(Direction.EAST, makeWall());
		room2.setSide(Direction.SOUTH, makeWall());
		room2.setSide(Direction.WEST, door);

		return maze;
	}

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

	public static void main(String[] args) {
		MazeGameCreator game = new MazeGameCreator();
		System.out.println("Simple maze using factory methods");
		System.out.println(game.create());
		game = new EnchantedMazeCreator();
		System.out.println("Enchanted maze using factory methods");
		System.out.println(game.create());
		game = new BombedMazeCreator();
		System.out.println("Bombed maze using factory methods");
		System.out.println(game.create());
	}

}
