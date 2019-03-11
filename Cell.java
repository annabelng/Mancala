package Mancala;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.applet.Applet;

import javax.swing.JPanel;

public class Cell extends JPanel{
	int x;
	int y;
	Color c;
	ArrayList<Pebble> cell;
	
	Pebble p1 = new Pebble(x,y);
	Pebble p2 = new Pebble(x,y+20);
	Pebble p3 = new Pebble(x+20,y);
	Pebble p4 = new Pebble(x+20,y+20);
	
	public Cell(int x, int y, Color c){
		this.x = x;
		this.y = y;
		this.c = c;
		cell = new ArrayList<Pebble>();
		
		cell.add(0,p1);
		cell.add(1,p2);
		cell.add(2,p3);
		cell.add(3,p4);
	}

	public void paint(Graphics g, int x, int y, int size){
		super.paintComponents(g);
		
		g.fillOval(x, y, size, size);
	
	}
	public int sizee(){
		int size = cell.size();
		return size;
	}
	public int getX(){
		return x;
	}
}