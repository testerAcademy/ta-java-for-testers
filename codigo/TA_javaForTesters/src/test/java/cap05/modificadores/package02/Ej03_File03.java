package cap05.modificadores.package02;

import cap05.modificadores.package01.Ej01_File01;

public class Ej03_File03 {
    public static void main(String[] args) {
        //llamar a "Ej01_File01.imprimirNombre3" public desde otro package
        Ej01_File01.imprimirNombre3("Invocar método public desde otro file (clase) y otro package");

        //No se puede llamar a "Ej01_File01.imprimirNombre2" protected desde otro package
        
    }
}
