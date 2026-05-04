package cap04.condicionales;

public class Ej02_BloqueIFElse {
    public static void main(String[] args) {
        String rol = "ventas";

        if(rol.equalsIgnoreCase("admin")) {
            System.out.println("Acceso");
        } else {
            System.out.println("Sin acceso");
        }
    }
}
