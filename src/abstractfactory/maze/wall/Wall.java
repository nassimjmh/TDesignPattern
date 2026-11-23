package abstractfactory.maze.wall;

import abstractfactory.maze.MapSite;

public class Wall implements MapSite {

	public void enter() {
		System.out.println("Ouch!");
	}

	public String toString() {
		return "wall";
	}

}
