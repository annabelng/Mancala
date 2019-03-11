package Mancala;

import java.awt.Color;
import java.util.ArrayList;

public class Cell {
	int x;
	int y;
	Color c;
	ArrayList<Pebble> cell;
	
	public Cell(int x, int y, Color c){
		this.x = x;
		this.y = y;
		this.c = c;
		cell = new ArrayList<Pebble>();
		
		Pebble p1 = new Pebble(x,y);
		Pebble p2 = new Pebble(x,y+20);
		Pebble p3 = new Pebble(x+20,y);
		Pebble p4 = new Pebble(x+20,y+20);
		
		cell.add(0,p1);
		cell.add(1,p2);
		cell.add(2,p3);
		cell.add(3,p4);
	}
}
