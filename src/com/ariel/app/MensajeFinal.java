package com.ariel.app;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MensajeFinal {

    ImageIcon iconP = new ImageIcon(getClass().getResource("/com/ariel/icons/icon-question.png"));
    ImageIcon iconE = new ImageIcon(getClass().getResource("/com/ariel/icons/icon-salir.png"));


    public void MensajeFinal() {
        System.out.println("Terminar");

        // Mostrar un cuadro de diálogo para preguntar si se desea continuar
        Object[] opciones = {"Sí", "No"};
        int opcionMensaje = JOptionPane.showOptionDialog(
                null,
                "¿Deseas continuar?",
                "Seleccione una opción:",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                iconP,
                opciones,
                opciones[0]
        );
        int mensaje = (Integer) opcionMensaje;

        // Continuar la aplicación si se elige "Sí"
        if (mensaje == 0) {
            MenuPrincipal iniciarApp = new MenuPrincipal();
            iniciarApp.iniciar();
        }
        // Mostrar un mensaje de finalización si se elige "No"
        else if (mensaje == 1) {
            JOptionPane.showMessageDialog(
                    null,
                    "Programa Finalizado",
                    "Muchas Gracias",
                    JOptionPane.INFORMATION_MESSAGE,
                    iconE
            );
        }
    }
}