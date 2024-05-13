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
import javax.swing.Timer;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLayeredPane;

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
	
	JLayeredPane whiteboard = new JLayeredPane(),costumers = new JLayeredPane(),pizaP = new JLayeredPane();
	JLabel pizaWlabel= new JLabel(),ingLW= new JLabel(),ing2LW= new JLabel(),ing3LW= new JLabel(),ing1= new JLabel(),ing2= new JLabel(),ing3= new JLabel(),background = new JLabel(),sauce1 = new JLabel(),sauce2 = new JLabel(),
			chese = new JLabel(),seaW = new JLabel(), anch = new JLabel(),calamar = new JLabel();
	ImageIcon pizaWlabelIMG,backgrounIMG = new ImageIcon("bg.png"),topping1 = new ImageIcon(),topping2 = new ImageIcon(), topping3 = new ImageIcon(),
			cheseIMG = new ImageIcon("cheese_box.png"),sauce1IMG = new ImageIcon("sauce.png"),sauce2IMG = new ImageIcon("sauce2.png"),seaWWIMG = new ImageIcon("topping_1_3_dropped.png"),anchWIMG = new ImageIcon("topping_4_3_dropped.png"),
			calamarWIMG = new ImageIcon("topping_3_3_dropped.png"),seaWIMG = new ImageIcon("topping_1_box.png"),anchIMG = new ImageIcon("topping_4_box.png"),
			calaIMG = new ImageIcon("topping_3_box.png");;
	int currentlyPressed;
	Timer time ;
	int pizaPos=0;
	
	
	
	
	
	public void game(JFrame frame){
		time = new Timer(10,null);
		background.setIcon(backgrounIMG);
		whiteboard.setOpaque(false);
		ingLW.setOpaque(false);
		ing2LW.setOpaque(false);
		ing3LW.setOpaque(false);
		pizaWlabel.setOpaque(false);
		costumers.setOpaque(false);
		sauce1.setOpaque(false);
		sauce2.setOpaque(false);
		chese.setOpaque(false);
		seaW.setOpaque(false);
		anch.setOpaque(false);
		calamar.setOpaque(false);
		pizaP.setOpaque(true);
		
		sauce1.addMouseListener(this);
		sauce2.addMouseListener(this);
		chese.addMouseListener(this);
		seaW.addMouseListener(this);
		anch.addMouseListener(this);
		calamar.addMouseListener(this);
		
		sauce1.addMouseListener(this);
		
		ingLW.setBounds(10, 10, 570, 60);
		ingLW.setFont(new Font("Impact", Font.PLAIN,50));
		ingLW.setIcon(seaWWIMG);
		int ing1NO = 1;
		ingLW.setText("  X "+ing1NO);
		
		
		ing2LW.setBounds(10, 70, 570, 60);
		ing2LW.setFont(new Font("Impact", Font.PLAIN,50));
		ing2LW.setIcon(anchWIMG);
		int ing2NO = 0;
		ing2LW.setText("  X "+ing2NO);
		
	
		ing3LW.setBounds(10, 130, 570, 60);
		ing3LW.setFont(new Font("Impact", Font.PLAIN,50));
		ing3LW.setIcon(calamarWIMG);
		int ing3NO = 2;
		ing3LW.setText("  X "+ing3NO);
		
		
		pizaWlabel.setBounds(10, 190, 570, 150);
		
		whiteboard.setBounds(1048, 42, 589, 329);
		
		 
		 //back integration
		pizaWlabel.setFont(new Font("Impact", Font.PLAIN,50));
		int pedidoS=1;
		if(pedidoS==1) {
			pizaWlabelIMG  = new ImageIcon("pizza_baseWSauce1.png");
			pizaWlabel.setText("  Marinara");
		}
		else {
			pizaWlabelIMG  = new ImageIcon("pizza_baseWSauce2.png");
			pizaWlabel.setText("  Hot Sauce");
		}
		
		pizaWlabel.setIcon(pizaWlabelIMG);
	
		
		
		
		
		costumers.setBounds(0, 350, 1700, 200);
		
		
		sauce1.setBounds(0,0,200,200);
		sauce1.setIcon(sauce1IMG);
		
		sauce2.setBounds(200, 0, 200, 200);
		sauce2.setIcon(sauce2IMG);
		
		chese.setBounds(400,0,400,200);
		chese.setIcon(cheseIMG);
		
		seaW.setBounds(800, 0, 300, 200);
		seaW.setIcon(seaWIMG);
		
		anch.setBounds(1100,0,300,200);
		anch.setBackground(Color.DARK_GRAY);
		anch.setIcon(anchIMG);
		
		calamar.setBounds(1400, 0, 300, 200);
		calamar.setBackground(Color.CYAN);
		calamar.setIcon(calaIMG);
		
		pizaP.setBounds(pizaPos, 574, 300, 300);
		
		pizaP.setBackground(Color.BLACK);
		
		costumers.add(sauce1);
		costumers.add(sauce2);
		costumers.add(chese);
		costumers.add(seaW);
		costumers.add(anch);
		costumers.add(calamar);
		
		
		
		
		frame.add(background);
		whiteboard.add(ingLW);
		whiteboard.add(ing2LW);
		whiteboard.add(ing3LW);
		whiteboard.add(pizaWlabel);
		
		
		background.add(pizaP);
		background.add(costumers);
		background.add(whiteboard);
		
		
		
		
		
		
		
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
		
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource()==sauce1) {
			currentlyPressed = 1;
			
			
		}
		else if(e.getSource()==sauce1) {
			currentlyPressed = 2;
			
		}
		else if(e.getSource()==sauce2) {
			currentlyPressed = 3;
			
		}
		else if(e.getSource()==chese) {
			currentlyPressed = 4;
			
		}
		else if(e.getSource()==seaW) {
			currentlyPressed = 5;
			
		}
		else if(e.getSource()==anch) {
			currentlyPressed = 6;
			
		}
		else if(e.getSource()==calamar) {
			currentlyPressed = 7;
			
		}
		
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
				game(this);
				place = 2;
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
		else if(place == 2) {
			System.out.println(time);
		if (e.getSource()== time) {
			while(pizaPos<= xDim){
				pizaP.setPosition(pizaP, pizaPos);
				pizaPos = pizaPos +1 ;
				}
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
