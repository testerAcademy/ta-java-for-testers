package cap04.loopsFor;

import java.util.ArrayList;
import java.util.List;

public class Ej01_ForClasico {
    public static void main(String[] args) {
        List<String> nombres = new ArrayList<>();
        nombres.add("Bicho");
        nombres.add("Zoe");
        nombres.add("Josy");
        nombres.add("Monica Sarahi");

        for(int i = 0; i < nombres.size(); i++){
            if(nombres.get(i).equalsIgnoreCase("Josy")){
                System.out.println("Nombre: " + nombres.get(i));
            }
        }
    }
}
