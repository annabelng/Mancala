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
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

//250 110
public class Driver extends JPanel implements ActionListener, KeyListener, MouseListener, MouseMotionListener {

	int screen_width = 1000;
	int screen_height = 472;

	String bg = "begin.png";
	JLabel background;

	Font font = new Font("Courier New", 1, 35);
	Board board;
	Pebble p;
	
	int[]test = new int[8];
	
	Cell c1 = new Cell(225, 70);
	Cell c2 = new Cell(415, 70);
	Cell c3 = new Cell(615, 70);
	Cell c4 = new Cell(780, 70);
	Cell c8 = new Cell(225, 265);
	Cell c7 = new Cell(415, 265);
	Cell c6 = new Cell(615, 265);
	Cell c5 = new Cell(780, 265);

	// 245 280
	public void paint(Graphics g) {
		super.paintComponents(g);

		board.paint(g);
		
		c1.paintPebble(c1, test[0], g);
		c2.paintPebble(c2, test[1], g);
		c3.paintPebble(c3, test[2], g);
		c4.paintPebble(c4, test[3], g);
		c5.paintPebble(c5, test[4], g);
		c6.paintPebble(c6, test[5], g);
		c7.paintPebble(c7, test[6], g);
		c8.paintPebble(c8, test[7], g);
		
	}

	public void update() {
		
	}

	// ============================ code above ==========================================
	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();
		repaint();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver d = new Driver();
		
	}

	public Driver() {

		JFrame f = new JFrame();
		f.setTitle("Mancala");
		f.setSize(screen_width, screen_height);
		f.getContentPane().setBackground(new Color(220, 220, 220));
		f.setResizable(false);
		f.addKeyListener(this);
		f.addMouseListener(this);

		board = new Board("Mancala.png");
		p = new Pebble("pebble.png");
		
		for(int i = 0; i < test.length; i++) {
			test[i] = 3;
		}
		
		f.add(this);

		// end creating objects
		t = new Timer(1000, this);
		
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	Timer t;

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

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getX()<=(c1.getX()+c1.getWidth()) && e.getX()>=c1.getX()) {
			
			System.out.println("test click");
			
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}