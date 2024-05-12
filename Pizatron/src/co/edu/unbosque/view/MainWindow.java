package co.edu.unbosque.view;


import java.awt.BorderLayout;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import co.edu.unbosque.view.Music;

public class MainWindow extends JFrame implements MouseListener, ActionListener, ChangeListener{
	
	int place = 0;
	boolean loadCon = false;
	boolean loadHelp = false;
	boolean loadGame = false;
	
	Music musica = new Music();
	public static float vol = 3;
	
	//Menu principal
	JPanel left = new JPanel(),buttonsPanel= new JPanel();
	ImageIcon bgImage,iconIMG = new ImageIcon("logo.png"),config = new ImageIcon("config.png"),help = new ImageIcon("info.png"),playBIMG = new ImageIcon("playB.png"),menu = new ImageIcon("menu.png");
	JButton playB = new JButton(playBIMG) ,configB = new JButton(config),infoB = new JButton(help);
	JLabel iconLabel = new JLabel();
	JTextPane leaderboard = new JTextPane();
	JLabel right = new JLabel();
	
	public static int xDim = 1700;
	public static int yDim = 800;
	
	//Menu Configuraciones
	JPanel configPanel = new JPanel() , mainCon = new JPanel();
	String[] sizes ={"1700,800","2000,1000",};
	JComboBox res = new JComboBox(sizes) ;
	JSlider volumen = new JSlider(0,6,3);
	JLabel resLabel = new JLabel(), volumenLabel = new JLabel();
	JButton backB = new JButton();
	ImageIcon backBIMG = new ImageIcon("backB.png");
	
	//Game configurations 
	
	
	
	
	
	
	
	
	
	public MainWindow() throws LineUnavailableException, UnsupportedAudioFileException, IOException{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(xDim,yDim);
		setVisible(true);
		
		setTitle("Pizzatron 3000");
		launchMenu(left,right,iconLabel,buttonsPanel,playB,configB,infoB,leaderboard,this,bgImage,iconIMG,config,help,playBIMG);
		
		setResizable(false);
		
		
		
		
		
	}
	public void changeLaunchMenu(JPanel left,JLabel Right) {
		place = 0;
		left.setVisible(true);
		right.setVisible(true);
	}
	public void changeConfig(JPanel configPanel) {
		place = 1;
		configPanel.setVisible(true);
	}
	
	public void launchMenu(JPanel left ,JLabel right  ,JLabel iconLabel ,JPanel buttonsPanel, JButton playB ,JButton configB ,JButton infoB ,JTextPane leaderboard ,JFrame frame,ImageIcon bgImage ,ImageIcon iconIMG,ImageIcon config,ImageIcon help,ImageIcon playBIMG) throws LineUnavailableException, UnsupportedAudioFileException, IOException{
		musica.play();
		volumen.addChangeListener(this);
		
		left.setVisible(true);
		right.setVisible(true);
		frame.setLayout(new BorderLayout());
		//left configurations
		int leftDimX = (xDim/2)+ 20;
		left.setPreferredSize(new Dimension(leftDimX,50));
		left.setLayout(new GridLayout(4,1));
		left.setBackground(new Color(0xFFC55A));
		//right config
		right.setIcon(menu);
		right.setPreferredSize(new Dimension((MainWindow.xDim/2)-20,yDim));
		
		
		//butonsPanel Config
		
		buttonsPanel.setLayout(new GridLayout(1,2));
		buttonsPanel.setBackground(new Color(0xFFC55A));
		

		
		
		//iconPanel config
		iconLabel = new JLabel();
		iconLabel.setBackground(Color.green);
		
		
		//playB config
		playB.setBounds(860-20,100,10,10);
		playB.setBorder(BorderFactory.createEmptyBorder());
		playB.setContentAreaFilled(false);
		playB.addActionListener(this);
		
	
		
		
		//configB config
		configB.setBorder(BorderFactory.createEmptyBorder());
		configB.setContentAreaFilled(false);
		configB.addActionListener(this);
		
		//infoB config
		infoB.setContentAreaFilled(false);
		infoB.setBorder(BorderFactory.createEmptyBorder());
		infoB.addActionListener(this);
		
		//leaderboards
		leaderboard = new JTextPane();
		leaderboard.setBorder(BorderFactory.createEtchedBorder());
		leaderboard.setBackground(new Color(0x2C4E80));
		appendToPane(leaderboard, "Position : Player : Score,\n\n", Color.WHITE,30);
		appendToPane(leaderboard, "1 :  AAA : 2000,\n", Color.WHITE,20);
		appendToPane(leaderboard, "2 : ABBB : 1000,\n", Color.WHITE,20);
		leaderboard.setEditable(false);
		
		
		
		
		
		frame.add(left,BorderLayout.WEST);
		frame.add(right,BorderLayout.CENTER);
		left.add(iconLabel);
		iconLabel.setIcon(iconIMG);
		left.add(leaderboard);
		left.add(playB);
		left.add(buttonsPanel);
		buttonsPanel.add(configB);
		buttonsPanel.add(infoB);
		frame.pack();
		
		
		
		
	}
	
	JPanel belt = new JPanel(),whiteboard = new JPanel(),costumers = new JPanel(),pizaP = new JPanel(),ingredients = new JPanel();
	JLabel beltL = new JLabel(),pizaWlabel= new JLabel(),ingLW= new JLabel(),ing2LW= new JLabel(),ing3LW= new JLabel(),ing1= new JLabel(),ing2= new JLabel(),ing3= new JLabel();
	ImageIcon beltIMG = new ImageIcon(),pizaWlabelIMG = new ImageIcon() ,ingWIMG = new ImageIcon() ,ing2WIMG= new ImageIcon(),ing3WIMG= new ImageIcon(),ing1IMG= new ImageIcon(), ing2IMG = new ImageIcon(),ing3IMG= new ImageIcon();
	
	public void game() {
		
	}
	
	public void config(JComboBox res,JFrame frame,JPanel mainCon,JPanel configPanel,JSlider volumen,JLabel resLabel,JLabel volumenLabel,JButton backB,ImageIcon backBIMG) {
		
		mainCon.setVisible(true);
		configPanel.setVisible(true);
		loadCon = true;
		
		place = 1;
		//config panel configuration 
		configPanel.setLayout(new BorderLayout());
		
		//volumen Config
		volumen.setSize(new Dimension(400,200));
		volumen.setPaintTicks(true);
		volumen.setPaintLabels(true);
		volumen.setMinorTickSpacing(1);
		volumen.setBackground(new Color(0xFFC56A));
		
		//volumenLabel Config
		volumenLabel.setHorizontalAlignment(JTextField.CENTER);
		volumenLabel.setText("Volumen");
		volumenLabel.setFont(new Font("Impact", Font.PLAIN,50));
		volumenLabel.setBackground(new Color(0xFFC56A));
		
		//mainCon
		mainCon.setLayout(new GridLayout(5,1));
		mainCon.setBackground(new Color(0xFFC55A));
		mainCon.add(res);
		mainCon.add(volumen);
		
		
		//res config
		res.addActionListener(this);
		frame.add(configPanel);
		res.setBackground(new Color(0x5BB4C4));
		
		
		//resLabel config
		resLabel.setHorizontalAlignment(JTextField.CENTER);
		resLabel.setText("Resolucion");
		resLabel.setFont(new Font("Impact", Font.PLAIN,50));
		resLabel.setBackground(new Color(0x5BB4C4));
		
		
		//backB config
		backB.setContentAreaFilled(false);
		backB.setIcon(backBIMG);
		backB.setBorder(BorderFactory.createEmptyBorder());
		backB.addActionListener(this);
		backB.setHorizontalAlignment(10);
		
		
		
		configPanel.add(mainCon,BorderLayout.CENTER);
		mainCon.add(backB);
		mainCon.add(resLabel);
		mainCon.add(res);
		mainCon.add(volumenLabel);
		mainCon.add(volumen);
		
		
		
	}
	public void helpChange() {
		
		
	}
	
	
	public static void appendToPane(JTextPane tp, String txt, Color clr,int size) {
        StyleContext sc = StyleContext.getDefaultStyleContext();
        javax.swing.text.AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, clr);
        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Impact");
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);
        int len = tp.getDocument().getLength();
        tp.setFont(new Font("Impact",Font.PLAIN,size));
        tp.setCaretPosition(len);
        tp.setCharacterAttributes(aset, false);
        tp.replaceSelection(txt);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(place == 0) {
			if(e.getSource()==playB) {
				System.out.println("play");
				left.setVisible(false);
				right.setVisible(false);
		}
			else if(e.getSource()==configB) {
				left.setVisible(false);
				right.setVisible(false);
				if(loadCon) {
					changeConfig(configPanel);
					
				}
				else {
					config(res,this,mainCon,configPanel,volumen,resLabel,volumenLabel,backB,backBIMG);
				}
		}
			else if(e.getSource()==infoB) {
				System.out.println("tutorial");
				left.setVisible(false);
				right.setVisible(false);
			}
		}
		if(place==1) {
			if(e.getSource()==res) {
				if(res.getSelectedItem()=="1700,800") {
					xDim = 1700;
					yDim = 800;
					this.setSize(xDim,yDim);
				}
				else if(res.getSelectedItem()=="2000,1000") {
					xDim = 2000;
					yDim = 1000;
					this.setSize(xDim,yDim);
				}
			}
			else if(e.getSource()==backB) {
				configPanel.setVisible(false);
				changeLaunchMenu(left,right);
				
			}
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if(e.getSource()==volumen) {
			vol = volumen.getValue();
			System.out.println(vol);
			musica.volumeCH(vol);
		}
		
		
	}

}
