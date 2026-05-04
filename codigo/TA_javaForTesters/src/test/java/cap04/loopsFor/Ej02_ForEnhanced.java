package cap04.loopsFor;

import java.util.ArrayList;
import java.util.List;

public class Ej02_ForEnhanced {
    public static void main(String[] args) {
        List<String> nombres = new ArrayList<>();
        nombres.add("bicho");
        nombres.add("kero");
        nombres.add("zoe");

        for(String nombre : nombres){
            if(nombre.equalsIgnoreCase("kero")){
                System.out.println(nombre);
            }
        }

    }
}
