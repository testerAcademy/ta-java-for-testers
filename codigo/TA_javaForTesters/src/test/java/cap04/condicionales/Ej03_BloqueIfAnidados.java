package cap04.condicionales;

public class Ej03_BloqueIfAnidados {
    public static void main(String[] args) {
        int edad = 30;
        boolean isInapam = true;

        if(edad < 2) {
            System.out.println("Bebe");
        } else if(edad >= 2 && edad <= 14) {
            System.out.println("Niño");
        } else {
            System.out.println("Adulto");
            int costoVuelo = 100;
            if (isInapam){
                System.out.println("DESCUENTO INAPAM");
                costoVuelo = 60;
            }
        }

    }
}
