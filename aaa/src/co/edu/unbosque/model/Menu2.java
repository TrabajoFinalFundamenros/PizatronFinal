package co.edu.unbosque.model;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu2 extends JFrame {

    public Menu2() {
      
        // Configuración del JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        // Creación de componentes
        JButton reiniciarButton = new JButton("Reiniciar Nivel");
        JButton salirButton = new JButton("Salir del Programa");
        JButton verPuntajesButton = new JButton("Ver Puntajes");

        // Acción para el botón de Reiniciar Nivel
        reiniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reiniciarNivel();
            }
        });

        // Acción para el botón de Salir del Programa
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salirDelPrograma();
            }
        });

        // Acción para el botón de Ver Puntajes
        verPuntajesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verPuntajes();
            }
        });

        // Diseño del formulario
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.add(reiniciarButton);
        panel.add(salirButton);
        panel.add(verPuntajesButton);

        add(panel);
    }

    // Método para reiniciar el nivel
    private void reiniciarNivel() {
        // Aquí va la lógica para reiniciar el nivel
        JOptionPane.showMessageDialog(this, "El nivel ha sido reiniciado.");
    }

    // Método para salir del programa
    private void salirDelPrograma() {
        System.exit(0);
    }

    // Método para ver los puntajes
    private void verPuntajes() {
        Puntajes puntajes = new Puntajes();
        puntajes.setPuntaje(150); // Aquí establece el puntaje obtenido en el juego
        puntajes.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Menu2 menupostgame = new Menu2();
                menupostgame.setVisible(true);
            }
        });
    }
}
