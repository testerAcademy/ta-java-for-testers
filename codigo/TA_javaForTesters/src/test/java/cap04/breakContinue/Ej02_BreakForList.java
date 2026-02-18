package cap04.breakContinue;

import java.util.ArrayList;
import java.util.List;

public class Ej02_BreakForList {
    /**
     * Analiza el código, Intenta hacer lo mismo pero usando While
     * @param args
     */
    public static void main(String[] args) {
        //Crear Lista
        List<String> nombresList = new ArrayList<>();
        nombresList.add("Bicho");
        nombresList.add("Zoe");
        nombresList.add("MaFer");
        nombresList.add("Josy");

        //Iterar Lista (usando size)
        for(String nombre : nombresList) {
            if(nombre.equalsIgnoreCase("mafer")) {
                System.out.println(nombre);
                break;
            }
        }
    }
}
