/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rodillo;

import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Dell
 */

    public class rodillo extends Thread {
    private JLabel label;  // Etiqueta que mostrará la imagen
    private String[] imagenes;  // Lista de nombres de imágenes
    private boolean girando;
    private Random random;

    public rodillo(JLabel label, String[] imagenes) {
        this.label = label;
        this.imagenes = imagenes;
        this.girando = true;
        this.random = new Random();
    }

     public rodillo(JLabel label) {
        // Asignamos el JLabel que se actualizará con las imágenes
        this.label = label;

        // Aquí colocamos los nombres de las imágenes que representan los símbolos del tragamonedas
        this.imagenes = new String[] {
            "cereza.png",
            "limon.png",
            "campana.png",
            "sandia.png"
        };

        this.girando = true;  // Inicialmente el rodillo está girando
        this.random = new Random();  // Objeto para generar números aleatorios
    }
     
    @Override
    public void run() {
        while (girando) {
            // Selecciona una imagen al azar
            int index = random.nextInt(imagenes.length);
            String imagenSeleccionada = imagenes[index];

            // Cambia la imagen en el JLabel
            label.setIcon(new ImageIcon(getClass().getResource("/images/" + imagenSeleccionada)));

            // Pausa para simular el giro del rodillo
            try {
                Thread.sleep(100);  // 100 milisegundos entre cambios de imagen
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void detener() {
        this.girando = false;
    }
}

