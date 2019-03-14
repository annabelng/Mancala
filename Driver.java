package Mancala;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.io.File;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

//250 110
public class Driver extends JPanel implements ActionListener, KeyListener, MouseListener, MouseMotionListener{

	int screen_width = 1000;
	int screen_height = 472;

	String bg = "Mancala.png";
	JLabel background;
	
	Font font = new Font ("Courier New", 1, 35);
	Board board;
	Pebble[] pebbs = new Pebble[4];
	Pebble[] pebbs2 = new Pebble[4];
	Pebble[] pebbs3 = new Pebble[4];
	Pebble[] pebbs4 = new Pebble[4];
	
	Cell c1 = new Cell(225,70);
	//430 70
	Cell c2 = new Cell(415, 70);
	Cell c3 = new Cell(615, 70);
	Cell c4 = new Cell(815, 70);
	public void paint(Graphics g){
		super.paintComponents(g);
		
		board.paint(g);
			
	}
	
	public void update(){
		
	}
	
	//============================ code above ==========================================
	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();
		repaint();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver d = new Driver();

	}
	
	public Driver(){
		
		JFrame f = new JFrame();
		f.setTitle("Mancala");
		f.setSize(screen_width, screen_height);
		f.getContentPane().setBackground(new Color (220, 220, 220));
		/*f.setResizable(false);
		f.addKeyListener(this);
		f.addMouseListener(this);
		
		board = new Board("Mancala.png");*/
		
		String src = new File("").getAbsolutePath()+"/src/"; //path to image setup
		ImageIcon backg = new ImageIcon(src+bg);    //setups icon image
		background = new JLabel(backg);
		background.setBounds(0, 0, 1000, 472);
		//set location and size of icon
		
		f.add(background);
		
		c1.drawPebble(c1, pebbs);
		c2.drawPebble(c2, pebbs2);
		c3.drawPebble(c3, pebbs3);
		c4.drawPebble(c4, pebbs4);
		
		for(int i= 0; i < pebbs.length; i++) {
			f.add(pebbs[i].getImg());
		}
		for(int i= 0; i < pebbs2.length; i++) {
			f.add(pebbs2[i].getImg());
		}
		for(int i= 0; i < pebbs3.length; i++) {
			f.add(pebbs3[i].getImg());
		}
		for(int i= 0; i < pebbs4.length; i++) {
			f.add(pebbs4[i].getImg());
		}
		
		f.add(background);
		f.setResizable(false);
		f.setLayout(null);
		f.addKeyListener(this);
		
		f.add(this);
		

		// end creating objects
		t = new Timer(17, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	Timer t;

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}