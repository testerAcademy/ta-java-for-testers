package cap04.condicionales;

public class Ej03_BloqueIfAnidado01 {
    public static void main(String[] args) {
        // Ejemplo 1. Un IF dentro de un IF
        boolean esAdmin = true;
        int edad = 18;

        if (esAdmin) {
            if (edad >= 18) {
                System.out.println("Acceso permitido");
            }
        }
    }
}
