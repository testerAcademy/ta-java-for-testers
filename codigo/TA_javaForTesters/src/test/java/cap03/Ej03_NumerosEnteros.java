package cap03;

public class Ej03_NumerosEnteros {
    public static void main(String[] args) {
        int diasTrabajados = 30;
        int sueldoDiario = 500;
        int subTotal = diasTrabajados * sueldoDiario;

        String bonoProductividad = "$5,500";
        bonoProductividad = bonoProductividad
                .replace("$", "")
                .replace(",", "")
        ;

        int total = subTotal + Integer.parseInt(bonoProductividad);

        System.out.println("Total a pagar: " + total);
    }
}




