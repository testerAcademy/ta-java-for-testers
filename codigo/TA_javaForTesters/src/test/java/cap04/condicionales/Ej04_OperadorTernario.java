package cap04.condicionales;

public class Ej04_OperadorTernario {
    public static void main(String[] args) {
        String rol = "admin";

        boolean isAdmin = (rol.equalsIgnoreCase("admin"))
                ? (1 == 1 ? true : false)
                : false;

        System.out.println(isAdmin);
    }
}
