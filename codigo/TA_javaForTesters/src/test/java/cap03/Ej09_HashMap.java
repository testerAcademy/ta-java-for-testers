package cap03;

import java.util.HashMap;

public class Ej09_HashMap {
    public static void main(String[] args) {
        //Crear Hashmap
        HashMap<String, String> persona = new HashMap<>();

        //Agregar datos (keys) a el Hashmap
        persona.put("nombre", "David");
        persona.put("apellido", "Chavez");
        persona.put("edad", "20");
        persona.put("peso", "70 kg");
        System.out.println("Persona: " + persona.toString());

        //Recuperar dato del Hashmap (key)
        String nombre = persona.get("nombre");
        System.out.println("nombre: " + nombre);
        int edad = Integer.parseInt( persona.get("edad") );
        System.out.println("Edad: " + edad);
        //Crees que podrías calcular cuantos meses a vivido esta persona?

        //Actualizar un dato (Key)
        //  intenta actualizar un dato que no existe
        persona.put("nombre", "Zoe");
        System.out.println("Persona: " + persona.toString());

        //Verificar si el Hashmap contien un dato (key)
        boolean contieneNombre = persona.containsKey("nombre");
        System.out.println("Persona contiene 'nombre': " + contieneNombre);

        //Eliminar una dato (key)
        persona.remove("peso");
        System.out.println("Persona: " + persona.toString());

    }
}
