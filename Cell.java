package Mancala;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.applet.Applet;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Cell extends JPanel {
	int x;
	int y;
	int width;
	int height;
	int circleWidth = 90;

	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
		width = 70;
		height = 70;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setHeight(int newHeight) {
		height = newHeight;
	}
	public void setWidth(int newWidth) {
		width = newWidth;
	}
	public int getWidth() {
		return width;
	}
	public int getCircleWidth() {
		return circleWidth;
	}

	public void paintPebble(Cell cell, int num, Graphics g) {
		Pebble[] pebbs = new Pebble[num];

		for (int i = 0; i < pebbs.length; i++) {
			int yRange = (int) (Math.random() * ((cell.getY() + cell.getWidth() - 15) - cell.getY()) + cell.getY());
			int xRange = (int) (Math.random() * ((cell.getX() + cell.getWidth() - 15) - cell.getX()) + cell.getX());
			pebbs[i] = new Pebble("pebble.png");
			pebbs[i].init(xRange, yRange);

			pebbs[i].paint(g);

		}
	}

}