package Mancala;

import java.awt.Graphics;

//home inherits the methods of cell 
//but has a different width and height

public class Home extends Cell{
	private int x,y;
	private int width, height;
	
	public Home(int x, int y) {
		super(x,y);
		this.width = 30;
		this.height = 255;
	}
	
}
