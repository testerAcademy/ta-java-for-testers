package cap04.loopsFor;

import java.util.ArrayList;
import java.util.List;

public class Ej07_ForBreak {
    public static void main(String[] args) {

        //Crear Lista
        List<String> nombresList = new ArrayList<>();
        nombresList.add("Bicho");
        nombresList.add("Zoe");
        nombresList.add("Josy");
        nombresList.add("Mary Fer");

        //Iterar Lista (usando size)
        for(String nombre : nombresList) {
            System.out.println(nombre);
            if(nombre.equalsIgnoreCase("mary fer")){
                System.out.println("Entro al IF. Se ejecuta BREAK");
                break;
            }
        }
        
    }
}
