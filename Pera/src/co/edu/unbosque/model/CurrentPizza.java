package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

public class CurrentPizza {
	public ArrayList<Integer> order = new ArrayList<Integer>(6);
	
	
	public ArrayList<Integer> pizaC = new ArrayList<Integer>();
	
	Random rad = new Random();
	
	ImageIcon b1Wcheese = new ImageIcon("pizza_baseWSauce1.png"),b1 = new ImageIcon("pizza_baseSauce1.png"),b2Wcheese = new ImageIcon("pizza_baseWSauce2.png"),b2 = new ImageIcon("pizza_baseSacuce2.png"),
			baseCheese = new ImageIcon("pizza_baseCheese.png"),pizaBaseIMG = new ImageIcon("pizza_base_clear.png");
public void initializeOrder(ArrayList<Integer> order) {
			//sauce1
			order.add(0);
			//sauce2
			order.add(0);
			//Cheese
			order.add(0);
			//Topping1Quantity
			order.add(0);
			//Toping2Quantity
			order.add(0);
			//Topping3Quantity
			order.add(0);
}
	int puntos =0;
	int a1 = 0 , a2 = 0, a3 = 0;
	int sauce = 0;
	public void startArrays(ArrayList<Integer> order,ArrayList<Integer> pizaC){
		int limit = 5;
		 a1 = rad.nextInt(6);
		 limit = limit - a1;
		 if (limit == 0) {
			 a2 = 0;
			 a3 = 0;
		 }else {
			 a2 = rad.nextInt(6);
			 while(a1+a2>5) {
				 a2 = rad.nextInt(6); 
			 }
			 limit = limit - a2;
			 if(limit==0) {
				 a3 = 0;
			 }
			 else {
				 a3 = rad.nextInt(6);
				 while(a1+a2+a3 > 5) {
					 a3 = rad.nextInt(6); 
				 }
			 }
		 }
		 if(a1+a2+a3==0) {
			 randomAsignation(a1, a2, a3);
		 }
		sauce = rad.nextInt(2);
		System.out.println(sauce);
		switch(sauce) {
		case 0:
			//sauce1
			order.set(0,1);
			order.set(1,0);
			break;
		case 1:
			//sauce2
			order.set(1,1);
			order.set(0,0);
			break;
		default:
			order.set(1,1);
			break;
		
				
		}
		//Cheese(Always 1)
		order.set(2,1);
		//Toppa1Quantity
		order.set(3,a1);
		//Topa2Quantity
		order.set(4,a2);
		//toppa3quantity
		order.set(5,a3);
		System.out.println(order);
		
		
		//sauce1
		pizaC.add(0);
		//sauce2
		pizaC.add(0);
		//Cheese
		pizaC.add(0);
		//Topping1Quantity
		pizaC.add(0);
		//Toping2Quantity
		pizaC.add(0);
		//Topping3Quantity
		pizaC.add(0);
		
	}
	
	public int pizaChecker(ArrayList<Integer> order,ArrayList<Integer> pizaC) {
		if(order.equals(pizaC)) {
			pizaC.clear();
			order.clear();
			return 1;
			
		}
		else if(pizaC.size()==0) {
			return 3;
		}
		else if(pizaC.get(3)+ pizaC.get(4) + pizaC.get(5) > 5) {
			pizaC.clear();
			return 2;
			
		}else if(pizaC.get(3)>order.get(3)) {
			pizaC.clear();
			return 2;
		}
		else if(pizaC.get(4)>order.get(4)) {
			pizaC.clear();
			return 2;
		}
		else if(pizaC.get(5)>order.get(5)) {
			pizaC.clear();
			return 2;
		}
		else return 0;
	}
		
	public void itemDrop(int index,ArrayList<Integer> pizaC){
		
		
		switch (index){
			case 1:
				pizaC.set(0, 1);
				if(pizaC.get(1)==1) {
					pizaC.set(1,0);
				}
				break;
			case 2:
				pizaC.set(1,1);
				if(pizaC.get(0)==1) {
					pizaC.set(0,0);
				}
				break;
			case 3:
				pizaC.set(2,1);
				break;
			case 4:
				pizaC.set(3,pizaC.get(3)+1);
				break;
			case 5:
				pizaC.set(4,pizaC.get(4)+1);
				break;
			case 6:
				pizaC.set(5,pizaC.get(5)+1);
				break;
		}
		
		
	}
	int history = 0 ;
	public ImageIcon iconSeterCases(int index,ArrayList<Integer> pizaC) {
		//System.out.println(index);
		//System.out.println(pizaC);
		switch(index){
		
		case 1: 
			if(pizaC.get(2)==0) {
				System.out.println("sauce 1");
				history = 1;
				return b1;
				
			}
			else if(pizaC.get(2)==1) {
				System.out.println("sauce 1 W cheese");
				history = 1;
				return b1Wcheese;
				
			}
			
		
			
		case 2:
			if(pizaC.get(2)==0) {
				System.out.println("sauce2");
				history = 2;
				return b2;
				
			}
			else if(pizaC.get(3)==1){
				history = 2;
				return b2Wcheese;
				
			}
		case 3:
			if(pizaC.get(0)==1) {
				history = 3;
				return b1Wcheese;
			}
			else if (pizaC.get(1)==1) {
				history = 3;
				return b2Wcheese;
			}
			else {
				history = 3;
				return baseCheese;
				
			}			
		default:
			if(pizaC.get(0) == 0 && pizaC.get(1) == 0 && pizaC.get(2) == 0) {
				return pizaBaseIMG;
			}
			else return iconSeterCases(history, pizaC);
			
		
		
			}
		}
	public void randomAsignation(int a1,int a2,int a3) {
		int limit = 5;
		 a1 = rad.nextInt(6);
		 limit = limit - a1;
		 if (limit == 0) {
			 a2 = 0;
			 a3 = 0;
		 }else {
			 a2 = rad.nextInt(6);
			 while(a1+a2>5) {
				 a2 = rad.nextInt(); 
			 }
			 limit = limit - a2;
			 if(limit==0) {
				 a3 = 0;
			 }
			 else {
				 a3 = rad.nextInt(6);
				 while(a1+a2+a3 > 5) {
					 a3 = rad.nextInt(6); 
				 }
			 }
		 }
		 if(a1+a2+a3==0) {
			 randomAsignation(a1, a2, a3);
		 }
	}
   }

	//pizza_baseSauce1.png
	
		

