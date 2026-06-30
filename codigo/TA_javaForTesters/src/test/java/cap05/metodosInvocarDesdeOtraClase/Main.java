package cap05.metodosInvocarDesdeOtraClase;

import cap05.metodosInvocarDesdeOtraClase.utils.Validaciones;
import cap05.metodosInvocarDesdeOtraClase.persona.Persona;

public class Main {
    public static void main(String[] args) {
        String nombre = "Zoe #$";
        boolean validarNombre = Validaciones.validarSoloTexto(nombre);
        System.out.println(validarNombre);

        //si el nombre NO es valido, se manda msj de error
        if (!validarNombre){
            System.out.println("El nombre no es valido");
            return;
        }

        //crear usuario
        Persona persona = new Persona();
        persona.crearPersona(nombre);
    }
}
