package Mancala;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Pebble extends JButton{
	//x and y for pebble
	private int x, y;
	
	//contains the image of the pebble
	private Image img;
	
	//allows the pebble image to be drawn
	AffineTransform tx = AffineTransform.getTranslateInstance(x, y);

	//param takes in the file of the img
	public Pebble(String filename){
		//connecting image to be able to draw
		tx = AffineTransform.getTranslateInstance(x, y);
		String src = new File("").getAbsolutePath() + "/src/";
		ImageIcon ast = new ImageIcon(src + filename);
		//setting x and y locations
		x = this.getX();
		y = this.getY();

		//get the image object is connected with
		img = getImage(filename);
	
		//initialize and set the bounds
		this.setBounds(this.getX(),this.getY(),50,52);
		init(x, y);
		
	}
	public void init(double a, double b) {
		tx.setToTranslation(a, b);
		
		tx.scale(1, 1);
	}
	//paint method that allows driver to paint the image instead of adding it to JFrame
	public void paint(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		this.setBounds(this.getX(),this.getY(),50,52);
		g2.drawImage(img, tx, null);		
	}
	
	//getters
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	//setters
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	//method that grabs the image and returns it
	private Image getImage(String path) {

		img = Toolkit.getDefaultToolkit().getImage("pebble2.png");
		return img;
	}
}