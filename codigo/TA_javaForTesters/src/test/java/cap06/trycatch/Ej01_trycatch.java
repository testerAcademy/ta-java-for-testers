package cap06.trycatch;

public class Ej01_trycatch {
    public static void main(String[] args) {

        int r = dividirNumero(10, 0);
        System.out.println(r);

    }

    private static int dividirNumero(int numero, int divisor) {
        int r = 0;
        try {
            r = numero / divisor;
        } catch (Exception e) {
            System.out.println("Get Message: " + e.getMessage());
            System.out.println("Get Cause: " + e.getCause());
            System.out.println("ToString: " + e.toString());
            if(e.getMessage().contains("by zero")) {
                System.out.println("Error. No se puede dividir entre 0");
            }
        }
        return r;
    }
}
