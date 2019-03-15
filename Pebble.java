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
	private int x;
	private int y;
	private int w, h;
	
	private Image img;
	
	AffineTransform tx = AffineTransform.getTranslateInstance(x, y);

	public Pebble(String filename){
		tx = AffineTransform.getTranslateInstance(x, y);
		String src = new File("").getAbsolutePath() + "/src/";
		ImageIcon ast = new ImageIcon(src + filename);
		x = this.getX();
		y = this.getY();

		img = getImage(filename);
		this.setBounds(this.getX(),this.getY(),50,52);
		init(x, y);
		
	}
	/*public JLabel getImg(){
		img.setBounds(x,y,w,h);
		return img; //getter for object's img
	}*/
	public void init(double a, double b) {
		tx.setToTranslation(a, b);
		
		tx.scale(1, 1);
	}
	public void paint(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		this.setBounds(this.getX(),this.getY(),50,52);
		g2.drawImage(img, tx, null);		
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
	

	private Image getImage(String path) {

		img = Toolkit.getDefaultToolkit().getImage("pebble.png");
		return img;
	}
}