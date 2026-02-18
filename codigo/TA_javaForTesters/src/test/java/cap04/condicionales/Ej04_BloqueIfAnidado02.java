package cap04.condicionales;

public class Ej04_BloqueIfAnidado02 {
    public static void main(String[] args) {
        // Ejemplo 2. If + Else If + Else
        int edad = 60; //cambia el valor de edad y analiza el comportamiento del código

        if (edad <= 12) {
            System.out.println("Niño");
        } else if (edad > 12 && edad <= 18) {
            System.out.println("Adolecente");
        } else {
            System.out.println("Adulto");
        }
    }
}
