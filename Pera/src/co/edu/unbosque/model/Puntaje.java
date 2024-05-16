package co.edu.unbosque.model;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class Puntaje {
	private JTextField nombreUsuarioTextField;
   
	public void guardarPuntaje(JTextField nombreUsuarioTextField,int puntaje,Object object) {
        String nombreUsuario = nombreUsuarioTextField.getText();

        if (!nombreUsuario.isEmpty()) {
            try (PrintWriter writer = new PrintWriter(new FileWriter("puntajes.txt", true))) {
                writer.println(nombreUsuario + ": " + puntaje+": "+object);
                writer.flush(); // Forzamos a vaciar el buffer para asegurarnos de que los datos se guarden
                
                nombreUsuarioTextField.setText("");
            } catch (IOException e) {
               
                e.printStackTrace();
            }
        } 
        
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
	public void leaderboardsConfig(JTextPane leaderboard) {
		 String nombreArchivo = "Puntajes.txt"; // Especifica la ruta y el nombre del archivo

	        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
	            String linea;
	            while ((linea = br.readLine()) != null) {
	                System.out.println(linea);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
	leaderboard.setBackground(new Color(0x2C4E80));
	appendToPane(leaderboard, "name : color : Score \n\n", Color.WHITE,30);
	 try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
		 String linea;
		 while ((linea = br.readLine()) != null) {
			 
			 appendToPane(leaderboard,linea , Color.WHITE,20);
		 }
	}
	catch (IOException e) {
        e.printStackTrace();
    	}
	}
}
