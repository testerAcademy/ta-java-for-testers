package cap03;

public class Ej07_Arrays {
    public static void main(String[] args) {
        // Array de nombres
        String[] nombres = {"David", "Zoe", "Josy"};

        // Mostrar los nombres, cambia el 0 por 1, 2
        //  y ve que pasa con 3
        System.out.println(nombres[1]);

        //actualiza nombre
        nombres[0] = "Bicho";
        System.out.println("1er nombre actualizado: " + nombres[0]);

    }

}
