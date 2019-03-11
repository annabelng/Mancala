package Mancala;
import java.awt.Color;
import java.awt.Graphics;
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


public class Board extends JPanel{

	Color brown = new Color(101, 76, 33);
	Color navy = new Color(0, 0, 128);
	int screen_width = 1200;
	int screen_height = 650;
	
	int topRowY = 80;
	int bottomRowY = 350;
	int topLeftX = 225;
	int bottomLeftX = 225;
	int size = 200;
	
	public void paint(Graphics g){
		super.paintComponents(g);
		
		//background
		g.setColor(brown);;
		g.fillRect(0, 0, screen_width, screen_height);
		
		//home
		g.setColor(navy);
		g.fillRect(30, 25, 170, 560);
		
		//painting the cells
		Cell c1 = new Cell(topLeftX,topRowY, navy);
		c1.paint(g,topLeftX,topRowY,size);
		
		Cell c2 = new Cell(topLeftX += 225,topRowY, navy);
		c2.paint(g,topLeftX,topRowY,size);
		
		Cell c3 = new Cell(topLeftX+=225,topRowY, navy);
		c3.paint(g,topLeftX,topRowY,size);
		
		Cell c4 = new Cell(topLeftX += 225,topRowY, navy);
		c4.paint(g,topLeftX,topRowY,size);
		
		Cell c5 = new Cell(bottomLeftX,bottomRowY, navy);
		c5.paint(g,bottomLeftX,bottomRowY,size);
		
		Cell c6 = new Cell(bottomLeftX+=225,bottomRowY, navy);
		c6.paint(g,bottomLeftX,bottomRowY,size);
		
		Cell c7 = new Cell(bottomLeftX+=225,bottomRowY, navy);
		c7.paint(g,bottomLeftX,bottomRowY,size);
		
		Cell c8 = new Cell(bottomLeftX+=225,bottomRowY, navy);
		c8.paint(g,bottomLeftX,bottomRowY,size);
		
		//int x = (int)(Math.random()*(325-225+1)+225);
		//int y = (int)(Math.random()*(180-80+1)+80);
		
		for(int i = 0, x = (int)(Math.random()*(325-225+1)+225); i < c1.sizee(); i++, x +=50){
			Pebble p = new Pebble(x,300);
			p.paint(g);
		}
		
		
	}
}
