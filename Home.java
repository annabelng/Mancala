package Mancala;

import java.awt.Graphics;

//home inherits all the methods of cell 
//but has a different width and height
public class Home extends Cell{
	private int x,y;
	private int width, height;
	
	public Home(int x, int y) {
		//super constructor that links back to cell
		super(x,y);
		//different width and height for home
		this.width = 100;
		this.height = 255;
	}
	
}