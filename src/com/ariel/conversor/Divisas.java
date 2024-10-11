package com.ariel.conversor;

import com.ariel.app.MensajeFinal;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Divisas {
    // Carga los íconos para mostrar en el cuadro de diálogo
    ImageIcon icon = new ImageIcon(getClass().getResource("/com/ariel/icons/icon-divisa.png"));
    ImageIcon iconM = new ImageIcon(getClass().getResource("/com/ariel/icons/icon-error.png"));
    public void convertirDivisa() {
        // Definir las opciones de conversión de divisas
        Object[] opcionesDivisa = {
                "USD a ARS",
                "ARS a USD",
                "USD a BRL",
                "BRL a USD",
                "USD a COP",
                "COP a USD",
                "USD a VES",
                "VES a USD"

        };

        // Mostrar el cuadro de diálogo para seleccionar una opción de conversión de divisas
        Object opcionElegida = JOptionPane.showInputDialog(
                null,
                "Seleccione una opción:",
                "Conversión de Divisas",
                JOptionPane.QUESTION_MESSAGE,
                icon,
                opcionesDivisa,
                opcionesDivisa[0]
        );
        System.out.println(opcionElegida);
        String opcionDivisaElegida = (String) opcionElegida;

        // Salir del programa si se cancela la selección de opción de conversión de divisas
        if (opcionElegida == null) {
            MensajeFinal mensajeFinal = new MensajeFinal();
            mensajeFinal.MensajeFinal();
            System.exit(0);
        }
        try {
            // Solicitar la cantidad a convertir
            Object opcionCantidadAConvertir = JOptionPane.showInputDialog(
                    null,
                    "Ingrese la cantidad que desea convertir de: " + opcionDivisaElegida,
                    "Conversión de Divisas",
                    JOptionPane.QUESTION_MESSAGE,
                    icon,
                    null,
                    null
            );
            String stringCantidadAConvertir = opcionCantidadAConvertir.toString();
            //double cantidadAConvertir = Double.parseDouble(stringCantidadAConvertir);

            // Realizar la operación de conversión
            DivisasCalculo operacion = new DivisasCalculo();
            operacion.resultadoConversion(opcionDivisaElegida, stringCantidadAConvertir);

        } catch(NumberFormatException | NullPointerException exception) {
            // Manejar errores de formato de número o selección nula
            JOptionPane.showMessageDialog(
                    null,
                    "I",
                    "Error",
                    JOptionPane.ERROR_MESSAGE,
                    iconM
            );
        }

        // Mostrar el mensaje final
        MensajeFinal mensajeFinal = new MensajeFinal();
        mensajeFinal.MensajeFinal();
    }
}
