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

	int moves = 0;
	int screen_width = 1000;
	int screen_height = 472;
	Home home = new Home(50, 100);
	boolean mouseClick = true;
	String bg = "begin.png";
	JLabel background;

	Font f = new Font("Din Condensed", Font.BOLD, 40);
	Font game = new Font("Din Condensed", Font.BOLD, 80);
	Board board;

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

		home.paintPebble(cells.get(8), a.test[8], g);
		
		g.setFont(f);
		String stringMoves = Integer.toString(moves);
		g.drawString("Moves Taken : " + stringMoves, 50, 40);
		
		if(a.test[8] == 24) {
			g.setColor(Color.BLACK);
			g.setFont(game);
			g.drawString("GAME OVER", screen_width/2 - 150, screen_height/2);
		}
		
		mouseClick = false;

	}

	public void update() {

	}

	// ============================ code above
	// ==========================================
	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();
		if (mouseClick == true) {
			repaint();
		}
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

		// first 4 cells
		for (int i = 0, x = 230, y = 70; i < 4; i++, x += 190) {
			Cell c = new Cell(x, y);
			cells.add(i, c);
		}
		// bottom 4 cells
		for (int i = 4, x = 800, y = 265; i < 8; i++, x -= 190) {

			Cell c = new Cell(x, y);
			cells.add(i, c);
		}

		Home home = new Home(30, 130);
		home.setWidth(100);
		cells.add(8, home);
		f.add(this);

		// end creating objects
		t = new Timer(100, this);

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
		mouseClick = true;

		if (e.getY() >= 50 && e.getY() <= 200) {
			if (e.getX() <= (cells.get(0).getX() + cells.get(0).getCircleWidth()) && e.getX() >= cells.get(0).getX()) {

				System.out.println("test click cell0");
				a.cellClicked(0);
				moves += 1;
			}
			if (e.getX() <= (cells.get(1).getX() + cells.get(1).getCircleWidth()) && e.getX() >= cells.get(1).getX()) {

				System.out.println("cell1");
				a.cellClicked(1);
				moves += 1;

			}
			if (e.getX() <= (cells.get(2).getX() + cells.get(2).getCircleWidth()) && e.getX() >= cells.get(2).getX()) {

				System.out.println("cell2");
				a.cellClicked(2);
				moves += 1;

			}
			if (e.getX() <= (cells.get(3).getX() + cells.get(3).getCircleWidth()) && e.getX() >= cells.get(3).getX()) {

				System.out.println("cell3");
				a.cellClicked(3);
				moves+=1;

			}
		}

		if (e.getY() >= 250 && e.getY() <= 360) {
			if (e.getX() <= (cells.get(4).getX() + cells.get(4).getCircleWidth()) && e.getX() >= cells.get(4).getX()) {

				System.out.println("cell4");
				a.cellClicked(4);
				moves+=1;

			}
			if (e.getX() <= (cells.get(5).getX() + cells.get(5).getCircleWidth()) && e.getX() >= cells.get(5).getX()) {

				System.out.println("cell5");
				a.cellClicked(5);
				moves+=1;

			}
			if (e.getX() <= (cells.get(6).getX() + cells.get(6).getCircleWidth()) && e.getX() >= cells.get(6).getX()) {

				System.out.println("cell6");
				a.cellClicked(6);
				moves+=1;

			}
			if (e.getX() <= (cells.get(7).getX() + cells.get(7).getCircleWidth()) && e.getX() >= cells.get(7).getX()) {

				System.out.println("cell7");
				a.cellClicked(7);
				moves+=1;
			}
		}
		System.out.println(moves);
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