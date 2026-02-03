package cap03;

import java.util.ArrayList;

public class Ej08_ArrayList {
    public static void main(String[] args) {
        // Crear lista de nombres
        ArrayList<String> nombres = new ArrayList<>();

        // Agregar elementos
        nombres.add("Bicho");
        nombres.add("Zoe");
        nombres.add("Josy");

        // Leer un dato (posición 0)
        System.out.println("Primer nombre: " + nombres.get(0));

        // Modificar un dato
        nombres.set(1, "Zoe Shaoran");

        // Agregar nuevo elemento
        nombres.add("Pacayo");

        // Eliminar un elemento
        nombres.remove("Josy");

        // Mostrar lista final
        System.out.println("Lista final: " + nombres);

    }

}
