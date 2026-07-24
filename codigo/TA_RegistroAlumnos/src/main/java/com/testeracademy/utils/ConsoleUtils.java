package com.testeracademy.utils;

import java.util.Scanner;

public class ConsoleUtils {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String ingresarTexto() {
        return SCANNER.nextLine();
    }

    public static int leerNumero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(SCANNER.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un número válido.");
            }
        }
    }

    public static void terminarScanner(){
        SCANNER.close();
    }

}
