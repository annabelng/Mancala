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


public class Driver extends JPanel implements ActionListener, KeyListener, MouseListener, MouseMotionListener{

	int screen_width = 1200;
	int screen_height = 650;
	
	//JLabel board;
	Font font = new Font ("Courier New", 1, 35);
	Color brown = new Color(101, 76, 33);
	Color navy = new Color(0, 0, 128);
	
	public void paint(Graphics g){
		super.paintComponents(g);
		
		Board board = new Board();
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
		f.setTitle("Tetris");
		f.setSize(screen_width, screen_height);
		f.getContentPane();
		f.setResizable(false);
		f.addKeyListener(this);
		f.add(this);
		

		// end creating objects
		t = new Timer(60, this);
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
