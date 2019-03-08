import java.util.List;


import java.util.ArrayList;

public class Cell {
	int x;
	int y;
	ArrayList<Pebble> cell;
	
	public Cell(){
		this.x = 100;
		this.y = 100;
		cell = new ArrayList<Pebble>();
	}
}
