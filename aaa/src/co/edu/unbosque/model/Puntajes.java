package co.edu.unbosque.model;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Puntajes extends JFrame {

    private JTextField nombreUsuarioTextField;
    private int puntaje;

    public Puntajes() {
        super("Tabla de Puntajes");

        // Configuración del JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        // Creación de componentes
        JLabel nombreUsuarioLabel = new JLabel("Nombre de Usuario:");
        nombreUsuarioTextField = new JTextField(15);

        JButton guardarButton = new JButton("Guardar");
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarPuntaje();
            }
        });

        // Diseño del formulario
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
        panel.add(nombreUsuarioLabel);
        panel.add(nombreUsuarioTextField);
        panel.add(guardarButton);

        add(panel);
    }

    // Método para guardar el puntaje en un archivo de texto
    private void guardarPuntaje() {
        String nombreUsuario = nombreUsuarioTextField.getText();

        if (!nombreUsuario.isEmpty()) {
            try (PrintWriter writer = new PrintWriter(new FileWriter("puntajes.txt", true))) {
                writer.println(nombreUsuario + ": " + puntaje);
                writer.flush(); // Forzamos a vaciar el buffer para asegurarnos de que los datos se guarden
                JOptionPane.showMessageDialog(this, "Puntaje guardado correctamente.");
                nombreUsuarioTextField.setText("");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al guardar el puntaje.", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un nombre de usuario.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public static void main(String[] args) {
        Puntajes puntajes = new Puntajes();
        puntajes.setPuntaje(150); // Aquí establece el puntaje obtenido en el juego
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                puntajes.setVisible(true);
            }
        });
    }
}
