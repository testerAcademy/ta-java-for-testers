package cap06.throw_throws;

public class Utils {

    public static void validarEdad(int edad) {
        if(edad < 18) {
            throw new IllegalArgumentException("Edad no permitida");
        }

        System.out.println("Edad correcta: " + edad);
    }

    public static void pausa(int segundosPausar) throws InterruptedException {
        long ms = segundosPausar * 1000L;
        Thread.sleep(segundosPausar);
        System.out.println("Codigo pausado por: " + segundosPausar + " segundos");
    }

    public static int divicionEnteros(int a, int b){
        return a / b;
    }

}
