package cap05.modificadores.package01;

public class Ej02_File2 {
    public static void main(String[] args) {
        //intenta llamar a "Ej01_File01.imprimirNombre"
        //  - no es posible ya que es private

        //llamar a "Ej01_File01.imprimirNombre3" public
        Ej01_File01.imprimirNombre3("Invocar método public desde otro file (clase) dentro del mismo package");

        //llamar a "Ej01_File01.imprimirNombre2" protected
        Ej01_File01.imprimirNombre2("Invocar método protected desde otro file (clase) dentro del mismo package");

    }
}
