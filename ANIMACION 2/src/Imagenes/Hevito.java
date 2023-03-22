
package Imagenes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Hevito extends JFrame implements ActionListener, ChangeListener {
    private final JLabel imagen;
    private final JSlider slider;
    private final Timer timer;
    private int velocidad;
    private int indiceActual;
    private final ImageIcon[] imagenes;

    public Hevito() {
        super("Animación con Slider");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        // Carga las imágenes en un arreglo
        imagenes = new ImageIcon[8];   

        imagenes[0] = new ImageIcon("1.jpeg");
        imagenes[1] = new ImageIcon("2.jpeg");
        imagenes[2] = new ImageIcon("3.jpeg");
        imagenes[3] = new ImageIcon("4.jpeg");
        imagenes[4] = new ImageIcon("5.jpeg");
        imagenes[5] = new ImageIcon("6.jpeg");
        imagenes[6] = new ImageIcon("7.jpeg");
        imagenes[7] = new ImageIcon("8.jpeg");

        // Crea la etiqueta para mostrar las imágenes
        imagen = new JLabel(imagenes[0]);
        panel.add(imagen);

        // Crea el slider para controlar la velocidad de la animación
        slider = new JSlider(JSlider.HORIZONTAL, 1, 10, 5);
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(this);
        panel.add(slider);

        // Configura el temporizador para la animación
        velocidad = slider.getValue();
        indiceActual = 0;
        timer = new Timer(1000 / velocidad, this);

        // Configura el frame
        setContentPane(panel);
        pack();
        setVisible(true);

        // Inicia la animación
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Actualiza la etiqueta con la siguiente imagen de la secuencia
        indiceActual++;
        if (indiceActual >= imagenes.length) {
            indiceActual = 0;
        }
        imagen.setIcon(imagenes[indiceActual]);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        // Actualiza la velocidad del temporizador cuando el usuario cambia el slider
        velocidad = slider.getValue();
        timer.setDelay(1000 / velocidad);
    }

    public static void main(String[] args) {
        new Hevito();
    }
}
