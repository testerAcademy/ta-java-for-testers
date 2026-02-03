package cap03;

public class Ej02_Strings {
    public static void main(String[] args) {
        String nombre = "david";
        String apellidoPaterno = "chavez";
        String apellidoMaterno = "avila";
        String nombreCompleto = nombre + " " + apellidoPaterno + " " + apellidoMaterno;

        //imprimir dando formato en el print
        System.out.println( nombre + " " + apellidoPaterno + " " + apellidoMaterno );

        //Imprimir variable con formato
        System.out.println(nombreCompleto);

        //Convertir en mayusculas
        System.out.println(nombreCompleto.toUpperCase());

        //Contar cuantas letras tiene un texto
        System.out.println("Cantidad de letras en el nombre = " + nombreCompleto.toUpperCase());
    }
}




