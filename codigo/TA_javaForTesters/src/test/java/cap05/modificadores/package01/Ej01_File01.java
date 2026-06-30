package cap05.modificadores.package01;

public class Ej01_File01 {
    public static void main(String[] args) {
        imprimirNombre("Invocar método private desde misma clase");
        imprimirNombre3("Invocar método public desde misma clase");
        imprimirNombre2("Invocar método protected desde misma clase");
    }

    private static void imprimirNombre(String nombre){
        System.out.println("Nombre: " + nombre);
        imprimirNombre3("Invocar método public desde misma clase dentro de método privado");
        imprimirNombre2("Invocar método protected desde misma clase dentro de método privado");
    }

    protected static void imprimirNombre2(String nombre) {
        imprimirNombre(nombre);
        imprimirNombre3("Invocar método public desde misma clase dentro de método protected");
    }

    public static void imprimirNombre3(String nombre) {
        imprimirNombre(nombre);
        imprimirNombre2("Invocar método protected desde misma clase dentro de método public");
    }
}
