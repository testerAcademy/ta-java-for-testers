package cap02.ej03_herencia;

public class Main {
    public static void main(String[] args) {
        Automovil auto = new Automovil();
        int autoRuedas = auto.obtenerRuedas();
        System.out.println("El auto tiene: " + autoRuedas + " ruedas");

        //Jueva comentando y descomentado las siguientes 3 lienas de codigo
        // para encender y apagar el auto
        //auto.apagar();
        auto.encender();

        boolean isMotorEncendido = auto.getMotorEncendido();
        System.out.println("El motor esta: " + isMotorEncendido);

    }
}
