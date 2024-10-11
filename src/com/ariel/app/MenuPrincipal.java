package com.ariel.app;

import com.ariel.conversor.Divisas;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal {
    public void iniciar() {
        // Carga el icono para mostrar en el cuadro de diálogo.
        ImageIcon icon = new ImageIcon(getClass().getResource("/com/ariel/icons/icon-next.png"));

        // Definir las opciones del menú
        Object[] opciones = { "Conversor de Divisas", "Salir del Programa" };

        JPanel panel = new JPanel();
        panel.setBackground(Color.GREEN);

        Object elegirOpcion = JOptionPane.showInputDialog(null,
                "Seleccione una opción:", "Menú Principal",
                JOptionPane.QUESTION_MESSAGE, icon, opciones, opciones[0]);

        if (elegirOpcion != null) {
            String opcionElegida = (String) elegirOpcion;

            if (opcionElegida.equals("Conversor de Divisas")) {
                Divisas conversorDivisas = new Divisas();
                conversorDivisas.convertirDivisa();
            }
        }
    }
}