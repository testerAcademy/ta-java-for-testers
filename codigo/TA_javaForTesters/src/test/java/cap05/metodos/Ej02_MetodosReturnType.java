package cap05.metodos;

public class Ej02_MetodosReturnType {
    public static void main(String[] args) {
        String datos = imprimirDatosPersona("Kero", 1);
        System.out.println(datos);

        String datos2 = imprimirDatosPersona("", 1);
        System.out.println(datos2);

    }

    private static String imprimirDatosPersona(String nombre, int edad){
        if(nombre.isEmpty()) {
            return "Error. El nombre es vacio";
        }
        String datos = "Nombre: " + nombre + ". Edad: " + String.valueOf(edad);
        return datos;
    }


}
