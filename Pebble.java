package Mancala;
import java.awt.Color;
import java.awt.Graphics;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Pebble {
	private int x;
	private int y;
	private int w, h;
	
	private JLabel img;
	
	public Pebble(String filename){
		
		String src =  new File("").getAbsolutePath()+"/src/";
		ImageIcon pebble = new ImageIcon(src+filename);
		//connect the file to the img
		img = new JLabel(pebble);
		
		x = 100;
		y = 200;
		w = 50;
		h = 52;
		
		img.setBounds(x,y,w,h);
		
	}
	public JLabel getImg(){
		img.setBounds(x,y,w,h);
		return img; //getter for object's img
	}

	public void paint(Graphics g) {
		
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