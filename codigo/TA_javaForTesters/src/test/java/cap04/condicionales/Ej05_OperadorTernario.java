package cap04.condicionales;

public class Ej05_OperadorTernario {
    public static void main(String[] args) {
        boolean esAdmin = true;

        // Ejemplo con esAdmin == true
        String acceso = (esAdmin == true) ? "Permitido" : "Denegado";
        System.out.println(acceso);

        // Ejemplo con esAdmin == true => Simplicando el comparador a true
        String acceso2 = (esAdmin) ? "Permitido" : "Denegado";
        System.out.println(acceso2);

        int edad = 18;
        String maryorEdad = (edad >= 18) ? "Es mayor" : "Es menor";

    }
}
