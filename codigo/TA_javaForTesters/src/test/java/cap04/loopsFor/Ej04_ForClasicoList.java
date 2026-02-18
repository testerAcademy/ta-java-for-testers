package cap04.loopsFor;

import java.util.ArrayList;
import java.util.List;

public class Ej04_ForClasicoList {
    public static void main(String[] args) {

        //Crear Lista
        List<String> nombresList = new ArrayList<>();
        nombresList.add("Bicho");
        nombresList.add("Zoe");

        //Iterar Lista (usando size)
        for(int i = 0; i < nombresList.size(); i++) {
            System.out.println(nombresList.get(i));
        }
        
    }
}
