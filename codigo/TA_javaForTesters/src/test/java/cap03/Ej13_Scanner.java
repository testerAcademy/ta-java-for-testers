package cap03;

import java.util.Scanner;

public class Ej13_Scanner {

    public static void main(String[] args) {   // Crear objeto Scanner
        Scanner sc = new Scanner(System.in);

        // Pedir nombre
        System.out.println("Ingresa tu nombre:");
        String nombre = sc.nextLine();

        // Pedir edad
        System.out.println("Ingresa tu edad:");
        int edad = sc.nextInt();

        // Mostrar resultado
        System.out.println("Hola " + nombre + ", tienes " + edad + " años.");

        // Cerrar Scanner
        sc.close();
    }

}
