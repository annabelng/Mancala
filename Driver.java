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

	//int[] test = new int[8];

	int topY = 70;
	int bottomY = 265;
	int x = 230;

	ArrayList<Cell> cells = new ArrayList<Cell>();
	Algorithm a = new Algorithm();

	// 245 280
	public void paint(Graphics g) {
		super.paintComponents(g);

		board.paint(g);
		for (int i = 0; i < 8; i++) {
			cells.get(i).paintPebble(cells.get(i), a.test[i], g);
		}

	}

	public void update() {

	}

	// ============================ code above
	// ==========================================
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
	

		//first 4 cells
		for (int i = 0, x = 230, y = 70; i < 4; i++, x += 190) {
			Cell c = new Cell(x, y);
			cells.add(i, c);
		}
		//bottom 4 cells 
		for (int i = 4, x = 800, y = 265; i < 8; i++, x -= 190) {

			Cell c = new Cell(x, y);
			cells.add(i, c);
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
		
		if (e.getX() <= (cells.get(0).getX() + cells.get(0).getWidth()) && 
				e.getX() >= cells.get(0).getX()) {
			if(e.getY() <= 140 && e.getY()>=70) {
			System.out.println("test click");
			a.cellClicked(0);
			}
		}
		if (e.getX() <= (cells.get(1).getX() + cells.get(1).getWidth()) && 
				e.getX() >= cells.get(1).getX()) {
			if(e.getY() <= 140 && e.getY()>=70) {
			System.out.println("test click");
			a.cellClicked(1);
			}
		}
		if (e.getX() <= (cells.get(2).getX() + cells.get(2).getWidth()) && 
				e.getX() >= cells.get(2).getX()) {
			if(e.getY() <= 140 && e.getY()>=70) {
			System.out.println("test click");
			a.cellClicked(2);
			}
		}
		if (e.getX() <= (cells.get(3).getX() + cells.get(3).getWidth()) && 
				e.getX() >= cells.get(3).getX()) {
			if(e.getY() <= 140 && e.getY()>=70) {
			System.out.println("test click");
			a.cellClicked(3);
			}
		}
		if (e.getX() <= (cells.get(4).getX() + cells.get(4).getWidth()) && 
				e.getX() >= cells.get(4).getX()) {
			if(e.getY() <= 335 && e.getY()>=265) {
			System.out.println("test click");
			a.cellClicked(4);
			}
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