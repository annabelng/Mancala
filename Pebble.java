
import java.awt.Color;
import java.awt.Graphics;

public class Pebble {
	int x;
	int y;
	Color c;
	
	public Pebble(int x, int y, Color c){
		this.x = x;
		this.y = y;
		this.c = c;
	}

	public void paint(Graphics g) {
		g.fillOval(x, y, 50, 50);
		g.setColor(c);
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