package Mancala;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.applet.Applet;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Cell extends JPanel {
	// x and y coordinates for cell
	private int x, y;
	// width and height for range that pebbles can be drawn in
	private int width, height;
	// actual width of circle
	private int circleWidth = 90;

	public Cell(int x, int y) {
		// sets the cell location based on parameters
		this.x = x;
		this.y = y;
		// initialize width and height
		width = 70;
		height = 70;
	}

	// getters
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getCircleWidth() {
		return circleWidth;
	}

	// setters
	public void setHeight(int newHeight) {
		height = newHeight;
	}

	public void setWidth(int newWidth) {
		width = newWidth;
	}

	// paint method to paint the pebbles
	// takes in the cell number for the location
	// and num for the number of pebbles to paint
	public void paintPebble(Cell cell, int num, Graphics g) {
		// create an array of pebble objects
		// with the amount specified in param
		Pebble[] pebbs = new Pebble[num];

		// loop through the array
		for (int i = 0; i < pebbs.length; i++) {
			// randomize the x and y location for the pebbles based on the range of the
			// cell's location
			int yRange = (int) (Math.random() * ((cell.getY() + cell.getWidth() - 15) - cell.getY()) + cell.getY());
			int xRange = (int) (Math.random() * ((cell.getX() + cell.getWidth() - 15) - cell.getX()) + cell.getX());
			// initialize the pebble object
			pebbs[i] = new Pebble("pebble2.png");
			//pebbs[i] = new Pebble("pebble2.png");
			// initialize the location based off of the x and y range
			pebbs[i].init(xRange, yRange);
			// paint the pebbles
			pebbs[i].paint(g);

		}
	}
}