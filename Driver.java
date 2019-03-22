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

public class Driver extends JPanel implements ActionListener, KeyListener, MouseListener, MouseMotionListener {

	int moves = 0;
	int screen_width = 1000;
	int screen_height = 472;
	Home home = new Home(50, 100);
	boolean mouseClick = true;
	boolean gameOver = false;
	String bg = "begin.png";
	JLabel background;

	// End endscreen;
	Font f = new Font("Din Condensed", Font.BOLD, 40);
	Font redo = new Font("Din Condensed", Font.CENTER_BASELINE, 25);
	Font game = new Font("Din Condensed", Font.BOLD, 180);
	Font pebb = new Font("Din Condensed", Font.BOLD, 30);
	Board board;
	// 61 85 193
	Color end = new Color(61, 85, 193);
	Color reset = new Color(88, 165, 214);
	Color back = new Color(172, 171, 171);

	int topY = 70;
	int bottomY = 265;
	int x = 230;

	ArrayList<Cell> cells = new ArrayList<Cell>();
	Algorithm a = new Algorithm();

	public void paint(Graphics g) {
		super.paintComponents(g);

		// painting the board png
		board.paint(g);

		// looping through and painting the pebbles in each cell
		// based on the cell location and the given number
		for (int i = 0; i < 8; i++) {
			cells.get(i).paintPebble(cells.get(i), a.test[i], g);
		}

		// paint the pebbles in the home cell
		home.paintPebble(cells.get(8), a.test[8], g);

		g.setFont(f);
		String stringMoves = Integer.toString(moves);
		g.drawString("MOVES TAKEN : " + stringMoves, 50, 40);

		g.setColor(back);
		g.fillRect(914, 1, 70, 45);
		g.setColor(reset);
		g.fillRect(910, 5, 70, 45);
		g.setFont(redo);
		g.setColor(Color.black);
		g.drawString("RESET", 921, 35);

		for (int i = 0, x = 270, y = 218; i < 4; i++, x += 190) {
			g.setFont(pebb);
			g.setColor(Color.BLACK);
			String pebbles = Integer.toString(a.test[i]);
			g.drawString(pebbles, x, y);
		}

		for (int i = 4, x = 840, y = 418; i < 8; i++, x -= 190) {
			String pebbles = Integer.toString(a.test[i]);
			g.drawString(pebbles, x, y);
		}

		if (a.test[8] == 24) {
			// endscreen.setVisible(true);
			g.setFont(game);
			g.setColor(end);
			g.drawString("GAME OVER", 170, 300);
			g.setColor(Color.WHITE);
			g.drawString("GAME OVER", 175, 300);
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

		String src = new File("").getAbsolutePath() + "/src/"; // path to image setup
		ImageIcon backg = new ImageIcon(src + bg); // setups icon image
		background = new JLabel(backg);
		background.setBounds(0, 0, 1000, 472); // set location and size of icon
		f.add(background);

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

		if (e.getKeyCode() == 32) {
			background.setVisible(false);
		}

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
			for (int i = 0; i < 4; i++) {
				if (e.getX() <= (cells.get(i).getX() + cells.get(i).getCircleWidth()) && e.getX() >= cells.get(i).getX()
						&& a.test[i] > 0) {

					System.out.println("test click cell" + i);
					a.cellClicked(i);
					moves += 1;
				}
			}
		}

		if (e.getY() >= 250 && e.getY() <= 390) {
			for (int i = 4; i < 8; i++) {
				if (e.getX() <= (cells.get(i).getX() + cells.get(i).getCircleWidth()) && e.getX() >= cells.get(i).getX()
						&& a.test[i] > 0) {

					System.out.println("test click cell" + i);
					a.cellClicked(i);
					moves += 1;
				}
			}
		}
		if (e.getX() >= 900 && e.getX() <= 970 && e.getY() >= 0 && e.getY() <= 65) {

			a = new Algorithm();
			moves = 0;
			System.out.println("RESET");

		}
		System.out.println("moves:" + moves);

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