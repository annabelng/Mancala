package Mancala;
import java.awt.Color;
import java.awt.Graphics;

public class Pebble {
	int x;
	int y;
	
	int r = (int)(Math.random()*(255-0-1));
	int g = (int)(Math.random()*(255-0-1));
	int b = (int)(Math.random()*(255-0-1));
			
	//Color c = new Color(r, g, b);
	Color c = Color.CYAN;
	
	
	public Pebble(int x, int y){
		this.x = x;
		this.y = y;
	}

	public void paint(Graphics g) {
		g.setColor(c);
		g.fillOval(x, y, 50, 50);
		
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
}