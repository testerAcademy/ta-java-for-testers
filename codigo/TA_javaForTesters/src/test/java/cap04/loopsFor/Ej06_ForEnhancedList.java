package cap04.loopsFor;

import java.util.ArrayList;
import java.util.List;

public class Ej06_ForEnhancedList {
    public static void main(String[] args) {

        //Crear Lista
        List<String> nombresList = new ArrayList<>();
        nombresList.add("Bicho");
        nombresList.add("Zoe");

        //Iterar Lista (usando size)
        for(String nombre : nombresList) {
            System.out.println(nombre);
        }
        
    }
}
