package Mancala;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.ImageObserver;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Pebble {
	private int x;
	private int y;
	
	Image img;
	AffineTransform tx = AffineTransform.getTranslateInstance(x, y);

	public Pebble(String filename){
		
		String src = new File("").getAbsolutePath() + "/src/";
		ImageIcon ast = new ImageIcon(src + filename);
		x = 0;
		y = 0;

		img = getImage(filename);
	
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		g2.drawImage(img, x, y, this);
	}

	
	public void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(2, 2);
	}
	/*public int getX(){
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
	}*/
	private Image getImage(String path) {

		img = Toolkit.getDefaultToolkit().getImage("pebble.png");
		return img;
	}
}