package cap04.condicionales;

public class Ej01_BloqueIF {
    public static void main(String[] args) {
        //Ejemplo 1. If con booleano
        boolean esAdmin = true;
        if (esAdmin ) {
            System.out.println("Acceso permitido");
        }

        //Ejemplo 2. If con String accediendo al método boolean equalsIgnoreCase
        String rolDeUsuario = "admin";
        if (rolDeUsuario.equalsIgnoreCase("admin")) {
            System.out.println("Acceso permitido");
        }

    }
}
