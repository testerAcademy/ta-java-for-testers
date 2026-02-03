package cap03;

public class Ej04_NumerosYStrings {
    public static void main(String[] args) {

        String nombre = "david chavez avila";
        int edad = 28;
        int diasTrabajados = 30;
        int sueldoDiario = 500;
        int total = diasTrabajados * sueldoDiario;

        //Convertir la edad en string
        System.out.println("El empleado: " + nombre
                + ". Tiene : " + String.valueOf(edad) +  " años"
        );
        System.out.println("Y gana: " + total + " USD");

    }
}




