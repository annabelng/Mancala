package Mancala;

import java.awt.Graphics;

public class Home extends Cell{
	private int x,y;
	private int width, height;
	
	public Home(int x, int y) {
		super(x,y);
		this.width = 30;
		this.height = 255;
	}
	public void paintPebble(int num, Graphics g) {
		Pebble[] pebbs = new Pebble[num];

		for (int i = 0; i < pebbs.length; i++) {
			int yRange = (int) (Math.random() * ((this.getY() + this.getHeight()) - this.getY()) + this.getY());
			int xRange = (int) (Math.random() * ((this.getX() + this.getWidth()) - this.getX()) + this.getX());
			pebbs[i] = new Pebble("pebble.png");
			pebbs[i].init(xRange, yRange);

			pebbs[i].paint(g);
		}
	}
	
}
