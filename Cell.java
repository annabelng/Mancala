package Mancala;

import java.util.ArrayList;

public class Cell {
	int x;
	int y;
	ArrayList<Pebble> cell;
	
	public Cell(int x, int y){
		this.x = x;
		this.y = y;
		cell = new ArrayList<Pebble>();
	}
}
