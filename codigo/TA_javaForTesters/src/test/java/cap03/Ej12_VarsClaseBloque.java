package cap03;

/**
 * Recuerda las variables tienen jerarquias:
 *      - Clase
 *          - Variables de clase
 *          - Variables estaticas
 *          - Metodos
 *              - Variables de bloque
 *              - Bloques IF, FOR, WHILE, ETC
 *                  - Variables de bloque solo dentro de las llaves
 *
 *  **Nota: no te preocupes por entender, métodos, IF, crear objetos de clase, más adelante aprenderas
 *  **Nota: por ahora enfocate en entender como las llaves en java van delimitando los bloques y jerarquias de código
 */
public class Ej12_VarsClaseBloque {

    //Variable estatica
    static String nombre = "Dave";
    //Variable de clase, similar a la estatica pero NO tiene prefijo static
    String apellido = "Garcia";

    public static void main(String[] args) {
        //Variable de bloque, solo existe en main y los subloques dentro de...
        int edad = 17;
        //Crear objeto para poder invocar variables de clase, ver linea 17
        Ej12_VarsClaseBloque estaClase = new Ej12_VarsClaseBloque();

        System.out.println(nombre);
        System.out.println(estaClase.apellido); //Variable de clase es invocada desde el objeto de clase
        System.out.println(edad); //imprimir variable de bloque
        if(edad > 18) {
            //variable de bloque, solo existe dentro del bloque de llaves del IF, lineas 19 a 22
           boolean esMayorEdad = true;
        }
    }

    //otro metodo NO estatico
    public void otroMetodo(){
        //Variables de clase se pueden acceder en métodos no static
        System.out.println(apellido);
    }
}
