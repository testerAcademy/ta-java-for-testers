package cap05.metodos;

public class Ej03_Parametros {
    public static void main(String[] args) {
        String nombre = "Kero";
        String apP = "Michino";
        String apM = "Gatiux";
        int edad = 2;

        saludoInicial(nombre);
        String datos = obtenerDatosPersona(nombre,  apP, apM, edad);
        System.out.println(datos);

    }

    private static void saludoInicial(String nombre){
        System.out.println("Hola, " + nombre + ". Bienvendio a Java for Testers!!!");
    }

    private static String obtenerDatosPersona(String nombre, String apellidoP,
                                               String apellidoM, int edad){
        if(nombre.isEmpty()) {
            return "Error. El nombre es vacio";
        }
        //Crea validaciones con condicional IF para validar que los apellidos no pueden ser vacios

        String datos = "Nombre: " + nombre + " " + apellidoP + " " + apellidoM + ". Edad: " + String.valueOf(edad);
        return datos;
    }
}
