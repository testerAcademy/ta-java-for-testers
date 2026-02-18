package cap04.breakContinue;

import java.util.ArrayList;
import java.util.List;

public class Ej06_ContinueWhileList {
    public static void main(String[] args) {
        // Crear Lista
        List<String> nombresList = new ArrayList<>();
        nombresList.add("Bicho");
        nombresList.add("Zoe");
        nombresList.add("MaFer");
        nombresList.add("Josy");

        // Iterar lista usando while
        int i = 0;

        while (i < nombresList.size()) {
            String nombre = nombresList.get(i);
            i++; // importante incrementar antes del continue

            if (!nombre.equalsIgnoreCase("mafer")) {
                continue; // salta si NO es MaFer
            }
            System.out.println(nombre);
        }

    }
}
