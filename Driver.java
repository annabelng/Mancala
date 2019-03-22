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

public class Driver extends JPanel implements ActionListener, KeyListener,
		MouseListener, MouseMotionListener {

	// instance variables for number of moves and screen width/height
	int moves = 0;
	int screen_width = 1000;
	int screen_height = 472;

	// declaring objects in the game
	Home home;
	Board board;

	// controls whether or not computer should repaint
	boolean mouseClick = true;
	// control for when to paint game over
	boolean gameOver = false;

	// file string and JLabel to contain the beginning/read me screen
	String bg = "begin.png";
	JLabel background;

	// initializing different fonts throughout the game
	Font move = new Font("Calibri", Font.BOLD, 40);
	Font redo = new Font("Calibri", Font.CENTER_BASELINE, 25);
	Font game = new Font("Calibri", Font.BOLD, 150);
	Font pebb = new Font("Calibri", Font.BOLD, 30);

	// different colors used to paint different objects
	Color end = new Color(61, 85, 193);
	Color reset = new Color(88, 165, 214);
	Color back = new Color(172, 171, 171);

	// arraylist to contain the 8 cells and 1 home
	ArrayList<Cell> cells = new ArrayList<Cell>();
	// declaring and initializing algorithm object
	Algorithm a = new Algorithm();

	public void paint(Graphics g) {
		super.paintComponents(g);

		// painting the board png
		board.paint(g);

		// looping through and painting the pebbles in each cell
		// by calling the paint function in cell, which is
		// based on the cell location and the given number
		for (int i = 0; i < 8; i++) {
			cells.get(i).paintPebble(cells.get(i), a.test[i], g);
		}

		// paint the pebbles in the home cell
		// even though home is a different object, it is a child class
		// and inherits the painting method as well
		home.paintPebble(cells.get(8), a.test[8], g);

		// set font for the "moves taken" string
		g.setFont(move);
		// cast moves integer to a string
		String stringMoves = Integer.toString(moves);
		// draw the string with the number of moves
		g.drawString("MOVES TAKEN : " + stringMoves, 50, 40);

		// set color and draw the reset button background
		g.setColor(back);
		g.fillRect(914, 1, 70, 45);
		// set color and draw the reset button foreground
		g.setColor(reset);
		g.fillRect(910, 5, 70, 45);
		// set font and draw string that says "reset"
		g.setFont(redo);
		g.setColor(Color.black);
		g.drawString("RESET", 915, 35);

		// drawing the numbers that count the # of pebbles in each cell
		// first 4 cells
		// starts at 270 for the leftmost cell and increments by constant of 190
		for (int i = 0, x = 270, y = 218; i < 4; i++, x += 190) {
			g.setFont(pebb);
			String pebbles = Integer.toString(a.test[i]);
			g.drawString(pebbles, x, y);
		}

		// bottom 4 cells - starting the right most cell and decrementing
		// by constant of 190
		for (int i = 4, x = 840, y = 418; i < 8; i++, x -= 190) {
			String pebbles = Integer.toString(a.test[i]);
			g.drawString(pebbles, x, y);
		}

		// checks if the home contains 24 pebbles, which is the max amount it
		// can have
		// 8 cells with 3 pebbles each = 24 pebbles
		if (a.test[8] == 24) {
			// set font and color for the back game over text layer
			g.setFont(game);
			g.setColor(end);
			g.drawString("GAME OVER", 125, 280);
			// paint second layer of game over text to give a 3d effect
			g.setColor(Color.WHITE);
			g.drawString("GAME OVER", 130, 280);
		}
		// resets mouseclick boolean control to false so if no clicks are
		// detected
		// the paint method won't continue to repainting
		mouseClick = false;

	}

	public void update() {

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();
		// only repaint if a mouseclick is detected
		if (mouseClick == true) {
			repaint();
		}
	}

	public static void main(String[] args) {
		Driver d = new Driver();

	}

	public Driver() {

		// creating JFrame, setting size and title
		JFrame f = new JFrame();
		f.setTitle("Mancala");
		f.setSize(screen_width, screen_height);
		f.getContentPane().setBackground(new Color(220, 220, 220));

		// setting up read-me/beginning screen so it's able to add the image to
		// the screen
		// path to image setup
		String src = new File("").getAbsolutePath() + "/src/";
		// setups icon image
		ImageIcon backg = new ImageIcon(src + bg);
		// connects imageicon back to the JLabel
		background = new JLabel(backg);
		// set location and size of icon
		background.setBounds(0, 0, 1000, 472);
		// add image to the JFrame
		f.add(background);

		// user can not stretch the screen
		f.setResizable(false);
		// adding different listeners
		f.addKeyListener(this);
		f.addMouseListener(this);

		// initializing board object and linking it with the Mancala png
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

		// initialize home object which is a child class of cell
		home = new Home(30, 130);
		// add home into the cell arraylist
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

		// checks if space bar is pressed
		if (e.getKeyCode() == 32) {
			// set visibility of the read-me/begin screen to false
			// so the game can begin
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
		// set boolean to true so repaint will paint the new number of pebbles
		mouseClick = true;

		// checks for the first row of cells
		// which is in between the y value of 50 and 200
		if (e.getY() >= 50 && e.getY() <= 200) {
			// loop through the first 4 cells (left to right)
			for (int i = 0; i < 4; i++) {
				// checks to see if the x coordinate of the mouse matches the
				// range of the cells
				// also checks to see if cell contains at least 1 pebble
				if (e.getX() <= (cells.get(i).getX() + cells.get(i)
						.getCircleWidth())
						&& e.getX() >= cells.get(i).getX()
						&& a.test[i] > 0) {

					// tests to check if click is working
					System.out.println("test click cell " + i);

					// once click has been detected
					// algorithm that the moves the numbers of pebbles is called
					// based off of which cell is clicked
					a.cellClicked(i);

					// add one to the number of moves
					moves += 1;
				}
			}
		}

		// checks for the second row of cells
		// which is between the y value of 250 and 390
		if (e.getY() >= 250 && e.getY() <= 390) {
			// loop through cells 4 through 8
			for (int i = 4; i < 8; i++) {
				// checks to see if the x coordinate of the mouse matches the
				// range of the cells
				// also checks to see if cell contains at least 1 pebble
				if (e.getX() <= (cells.get(i).getX() + cells.get(i)
						.getCircleWidth())
						&& e.getX() >= cells.get(i).getX()
						&& a.test[i] > 0) {

					System.out.println("test click cell" + i);
					// once click has been detected
					// algorithm that the moves the numbers of pebbles is called
					// based off of which cell is clicked
					a.cellClicked(i);
					// add one to moves
					moves += 1;
				}
			}
		}
		// checks to see if user clicks the reset button
		if (e.getX() >= 900 && e.getX() <= 970 && e.getY() >= 0
				&& e.getY() <= 65) {

			// re-initializes the algorithm object
			// which resets all of the arrays and arraylists
			a = new Algorithm();
			// resets moves back to 0
			moves = 0;
			// test to see if it reset
			System.out.println("RESET");

		}
		// moves check
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