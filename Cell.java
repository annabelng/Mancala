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
	
	public Cell(int x, int y, Color c){
		this.x = x;
		this.y = y;
		this.c = c;
		cell = new ArrayList<Pebble>();

	}

	public void paint(Graphics g, int x, int y, int size){
		super.paintComponents(g);
		
		g.fillOval(x, y, size, size);
		
		Pebble p = new Pebble(100,200,c);
		//p1.paint(g);
		//p1.paint(g);
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	ArrayList<ArrayList<Integer>> cells = new ArrayList<ArrayList<Integer>>();
	
	public void cellClicked (int n){
		if (x == n) {
			if (cells.get(x).size() >= cells.size() - x) {
				for (int i = x + 1; i < cells.size(); i++) {
					ArrayList<Integer> cell = cells.get(i);
					cell.add(0, 0);
					cells.get(x).remove(0);
				}
				int temp = cells.get(x).size();
				for (int i = 0; i < temp; i++) {
					ArrayList<Integer> cell = cells.get(i);
					cell.add(0, 0);
					cells.get(x).remove(0);
				}
			} else {
				int temp = cells.get(x).size();
				for (int i = x + 1; i <= x + temp; i++) {
					ArrayList<Integer> cell = cells.get(i);
					cell.add(0, 0);
					cells.get(x).remove(0);
				}
			}
			System.out.println(cells);
		}
	}
	
	
}
