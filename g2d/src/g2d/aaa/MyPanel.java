package g2d.aaa;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MyPanel extends JPanel implements ActionListener {
	String imagePath = "C:\\Users\\Usuario\\Documents\\GitHub\\PizatronFinal\\g2d\\pizza_base_clear.png";
	BufferedImage myPicture;

	
	int with = 300;
	int height = 300;
	Image piza;
	Timer timer ;
	int xVel=1;
	int x=0;
	int y=100;
	
	MyPanel() throws IOException{
		setPreferredSize(new Dimension(with,height));
		setBackground(Color.BLACK);
		timer = new Timer(10,null);
		myPicture = ImageIO.read(new File(imagePath));
		Graphics2D g = (Graphics2D) myPicture.getGraphics();
		g.setColor(Color.BLUE);
		

	}
	
	public void pain(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(myPicture,x,y,null);
		g.drawRect(10, 10, myPicture.getWidth() - 20, myPicture.getHeight() - 20);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
