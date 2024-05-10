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

public class MainWindow extends JFrame implements MouseListener, ActionListener, ChangeListener{
	
	int place = 0;
	boolean loadCon = false;
	boolean loadHelp = false;
	boolean loadGame = false;
	
	
	//Menu principal
	JPanel left = new JPanel(),right = new JPanel(),buttonsPanel= new JPanel();
	ImageIcon bgImage,iconIMG = new ImageIcon("logo.png"),config = new ImageIcon("config.png"),help = new ImageIcon("info.png"),playBIMG = new ImageIcon("playB.png"),bg = new ImageIcon("bg.png");
	JButton playB = new JButton(playBIMG) ,configB = new JButton(config),infoB = new JButton(help);
	JLabel iconLabel = new JLabel(), bgL = new JLabel();
	JTextPane leaderboard = new JTextPane();
	int xDim = 1700 ,yDim = 800;
	
	//Menu Configuraciones
	JPanel configPanel = new JPanel() , mainCon = new JPanel(),textP = new JPanel();
	String[] sizes ={"1700,800","2000,1000"};
	JComboBox res = new JComboBox(sizes) ;
	JSlider volumen = new JSlider(0,100,50);
	JLabel resLabel = new JLabel(), volumenLabel = new JLabel(),playerNlabel = new JLabel();
	JButton backB = new JButton(), summit = new JButton();
	ImageIcon backBIMG = new ImageIcon("backB.png");
	JTextField txtF = new JTextField();
	
	//Game configurations
	JLabel bggL = new JLabel(), belt = new JLabel(), pizza = new JLabel(), topping1,topping2 = new JLabel(),topping3 = new JLabel(),
	whiteboard = new JLabel() ,ingridient1W = new JLabel(), ingridient2W = new JLabel(),
	ingridient3W = new JLabel(),sauce1 = new JLabel(), sauce2 = new JLabel(),seaW = new JLabel(), anch = new JLabel(), calam = new JLabel(),coins = new JLabel(),
	cheese = new JLabel();
	JPanel cNp = new JPanel(), ingredients = new JPanel(), wBoard = new JPanel();
	ImageIcon bgg = new ImageIcon("background.png");
	
	
	
	
	
	public MainWindow(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(xDim,yDim);
		setVisible(true);
		setTitle("Pizzatron 3000");
		launchMenu(left,right,iconLabel,buttonsPanel,playB,configB,infoB,leaderboard,this,bgImage,iconIMG,config,help,playBIMG,bg,bgL);
		
		setResizable(false);
		
		
		
		
		
	}
	public void changeLaunchMenu(JPanel left,JPanel Right) {
		place = 0;
		left.setVisible(true);
		right.setVisible(true);
	}
	public void changeConfig(JPanel configPanel) {
		place = 1;
		configPanel.setVisible(true);
	}
	
	public void launchMenu(JPanel left ,JPanel right  ,JLabel iconLabel ,JPanel buttonsPanel, JButton playB ,JButton configB ,JButton infoB ,JTextPane leaderboard ,JFrame frame,ImageIcon bgImage ,ImageIcon iconIMG,ImageIcon config,ImageIcon help,ImageIcon playBIMG,ImageIcon bg,JLabel bgL){
		left.setVisible(true);
		right.setVisible(true);
		frame.setLayout(new BorderLayout());
		
		
		
		
		//left configurations
		int leftDimX = (xDim/2)+ 20;
		left.setPreferredSize(new Dimension(leftDimX,50));
		left.setLayout(new GridLayout(4,1));
		left.setBackground(new Color(0xFFC55A));
		
		
		//right configurations
		right.setPreferredSize(new Dimension((xDim/2)-20,50));
		right.add(bgL);
		bgL.setIcon(bg);
		
		
		
		
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
		iconLabel.setIcon(iconIMG);
		left.add(iconLabel);
		left.add(leaderboard);
		left.add(playB);
		left.add(buttonsPanel);
		buttonsPanel.add(configB);
		buttonsPanel.add(infoB);
		
		
		
		
	}
	
	public void config(JComboBox res,JFrame frame,JPanel mainCon,JPanel configPanel,JPanel textP,JLabel playerNlabel , JSlider volumen,JLabel resLabel,JLabel volumenLabel,JButton backB,ImageIcon backBIMG,JButton summit,JTextField txtF) {
		
		mainCon.setVisible(true);
		configPanel.setVisible(true);
		loadCon = true;
		
		//tstF config 
		
		txtF.setPreferredSize(new Dimension(1000,50));
		txtF.setFont(new Font("Impact",Font.BOLD,40));
		
		//playerNlabel config
		playerNlabel.setHorizontalAlignment(JTextField.CENTER);
		playerNlabel.setText("Nombre del Jugador");
		playerNlabel.setFont(new Font("Impact", Font.PLAIN,50));
		playerNlabel.setBackground(new Color(0xFFC56A));
		
		//summit config
		summit.addActionListener(this);
		summit.setPreferredSize(new Dimension(200,50));
		summit.setFont(new Font("impact",Font.PLAIN,20));
		summit.setText("OK");
		
		
		
		//textP config
		textP.setBackground(new Color(0xFFC56A));
		textP.add(txtF);
		textP.add(summit);
		
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
		mainCon.setLayout(new GridLayout(7,1));
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
		mainCon.add(playerNlabel);
		mainCon.add(textP);
		mainCon.add(resLabel);
		mainCon.add(res);
		mainCon.add(volumenLabel);
		mainCon.add(volumen);
		
		
	}
	
	
	public void help(JPanel instructionsL,JPanel instructionsR, JPanel pizzaT,JPanel menu,JPanel toppings, JPanel count,JLabel pTittle,JLabel pDes ,JLabel menuTittle, JLabel menuDes,JButton backB) {
		
		
	}
	public void game(JLabel bggL,JLabel belt,JLabel pizza,JLabel topping1,JLabel topping2,JLabel topping3,JLabel whiteboard , JLabel ingridient1W,JLabel ingridient2W,JLabel ingridient3W,JLabel sauce1,JLabel sauce2,JLabel seaW,JLabel anch ,JLabel calam,JLabel coins,JLabel cheese,JPanel cNp,JPanel ingredients,JPanel wBoard,JFrame frame,ImageIcon bgg){
		whiteboard.add(ingridient1W);
		whiteboard.add(ingridient2W);
		whiteboard.add(ingridient3W);
		frame.add(bggL);
		bggL.setIcon(bgg);
		
		ingredients.setBackground(Color.BLUE);
		cNp.setBackground(Color.red);
		whiteboard.setBackground(Color.WHITE);
		
		
		pizza.setSize(new Dimension(200,200));
		topping1.setSize(new Dimension(50,50));
		topping2.setSize(new Dimension(50,50));
		topping3.setSize(new Dimension(50,50));
		pizza.add(topping1);
		pizza.add(topping2);
		pizza.add(topping3);
		
		ingredients.setLayout(new GridLayout(1,6));
		ingredients.add(sauce1);
		ingredients.add(sauce2);
		ingredients.add(cheese);
		ingredients.add(seaW);
		ingredients.add(anch);
		ingredients.add(calam);
		
		cNp.add(belt);
		belt.add(pizza);
		bggL.add(cNp,BorderLayout.SOUTH);
		bggL.add(ingredients,BorderLayout.CENTER);
		bggL.add(whiteboard,BorderLayout.WEST);
		
		
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
				game(bggL,belt,pizza,topping1,topping2,topping3,whiteboard ,ingridient1W,ingridient2W,ingridient3W, sauce1,sauce2,seaW,anch ,calam,coins,cheese, cNp,ingredients,wBoard,this,bgg);
		}
			else if(e.getSource()==configB) {
				left.setVisible(false);
				right.setVisible(false);
				if(loadCon) {
					changeConfig(configPanel);
					
				}
				else {
					config(res,this,mainCon,configPanel,textP,playerNlabel,volumen,resLabel,volumenLabel,backB,backBIMG,summit,txtF);
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
			else if(e.getSource()==summit) {
				String name = txtF.getText();
				System.out.println("backEnd "+ name);
			}
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		
		
	}