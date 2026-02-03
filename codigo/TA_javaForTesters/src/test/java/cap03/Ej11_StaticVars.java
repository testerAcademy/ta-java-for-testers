package cap03;

public class Ej11_StaticVars {
    //variables estaticas siempre llevan la palabra static al inicio
    static String nombre = "Shaoran";
    static int edad = 33;

    //nota como main es static
    public static void main(String[] args) {
        //Variables estaticas solo pueden ser invocadas dentro de un método tipo estatico
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
    }

}
