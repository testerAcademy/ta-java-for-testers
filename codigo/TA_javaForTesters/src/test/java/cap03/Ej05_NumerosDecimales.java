package cap03;

public class Ej05_NumerosDecimales {
    public static void main(String[] args) {
        int diasTrabajados = 30;
        double sueldoDiario = 599.99;
        double total = Double.parseDouble(String.valueOf(diasTrabajados)) * sueldoDiario;

        System.out.println("Total a pagar: " + total + " USD");
    }

}
