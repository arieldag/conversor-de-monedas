package com.ariel.conversor;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class DivisasCalculo {
    ImageIcon icon = new ImageIcon(getClass().getResource("/com/ariel/icons/icon-divisa.png"));
    Scanner scanner = new Scanner(System.in);

    public void resultadoConversion(String tipoDivisa, String cantidadAConvertir) {
        // Crear un arreglo para almacenar los datos necesarios para la API
        String[] datosAPI = new String[3];
        String deDivisa = "", aDivisa = "";

        // Determinar las divisas de origen y destino según el tipo de conversión seleccionado
        switch (tipoDivisa) {
            case "USD a ARS":
                deDivisa = "USD";
                aDivisa = "ARS";
                break;
            case "ARS a USD":
                deDivisa = "ARS";
                aDivisa = "USD";
                break;
            case "USD a BRL":
                deDivisa = "USD";
                aDivisa = "BRL";
                break;
            case "BRL a USD":
                deDivisa = "BRL";
                aDivisa = "USD";
                break;
            case "USD a COP":
                deDivisa = "USD";
                aDivisa = "COP";
                break;
            case "COP a USD":
                deDivisa = "COP";
                aDivisa = "USD";
                break;
            case "USD a VES":
                deDivisa = "USD";
                aDivisa = "VES";
                break;
            case "VES a USD":
                deDivisa = "VES";
                aDivisa = "USD";
                break;
            default:
                System.out.println("Opción de conversión no válida");
                return; // Salir del método si la opción no es válida
        }
        try {
            // Reemplazar la coma por un punto en la cantidad a convertir
            cantidadAConvertir = cantidadAConvertir.replace(",", ".");

            // Imprimir la cantidad a convertir para verificar su formato
            System.out.println("Cantidad a convertir: " + cantidadAConvertir);

            // Obtener la fecha actual y formatearla
            LocalDate actualDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLL yyyy");
            String fechaFormateada = actualDate.format(formatter);

            // Actualizar los datos necesarios para la API
            datosAPI[0] = cantidadAConvertir;
            datosAPI[1] = deDivisa;
            datosAPI[2] = aDivisa;

            // Realizar la llamada a la API y obtener la cantidad convertida
            DivisasApi res = new DivisasApi();
            double cantidadConvertida = res.get(datosAPI[0], datosAPI[1], datosAPI[2]);

            // Mostrar el resultado de la conversión en un cuadro de diálogo
            JOptionPane.showMessageDialog(
                    null,
                    "$" + datosAPI[0] + " " + datosAPI[1] + " equivale a $" + cantidadConvertida + " " + datosAPI[2],
                    fechaFormateada,
                    JOptionPane.INFORMATION_MESSAGE,
                    icon
            );
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(
                    null,
                    "Error al realizar la conversión. Por favor, inténtelo de nuevo más tarde.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {
        DivisasCalculo conversor = new DivisasCalculo();
        conversor.resultadoConversion("USD a ARG", "");
    }
}
