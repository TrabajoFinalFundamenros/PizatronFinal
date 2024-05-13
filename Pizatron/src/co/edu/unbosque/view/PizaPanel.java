package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.ImageIcon;

public class PizaPanel extends JPanel implements ActionListener{
	final int with = 300;
	final int height = 300;
	Image piza;
	Timer timer;
	int xVel = 1;
	int x = 0;
	int y = 574;
	PizaPanel(){
		this.setSize(new Dimension(with,height));
		this.setBackground(Color.BLACK);
		piza = new ImageIcon("pizza_base_clerar.png").getImage();
		timer = new Timer(10,null);
		
		
		
	}
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.drawImage(piza,x,y,null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
