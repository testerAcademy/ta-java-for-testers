package cap02.ej04_polimorfismo;

public class Main {
    public static void main(String[] args) {
        Automovil auto = new Automovil();
        auto.encender();

        Motocicleta moto = new Motocicleta();
        moto.encender();
    }
}
