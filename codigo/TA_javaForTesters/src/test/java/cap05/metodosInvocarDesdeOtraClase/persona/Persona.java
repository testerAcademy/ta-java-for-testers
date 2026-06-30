package cap05.metodosInvocarDesdeOtraClase.persona;

public class Persona {

    public boolean crearPersona(String nombre) {
        System.out.println("Se creo la persona");
        System.out.println(nombre);
        return  true;
    }

    public boolean consultarPersona(String id) {
        System.out.println("Consultando la info de la persona con id: " + id);
        return  true;
    }
}
