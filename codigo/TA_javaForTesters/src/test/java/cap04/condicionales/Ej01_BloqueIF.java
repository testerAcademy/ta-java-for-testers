package cap04.condicionales;

public class Ej01_BloqueIF {
    public static void main(String[] args) {
        int edad = 17;
        boolean isAdmin = false;

        if( isAdmin || edad >= 18 ) {
            System.out.println("Admin mayor de edad");
        }

    }
}
