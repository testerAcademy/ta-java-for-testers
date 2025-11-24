package cap02.ej03_herencia;

public class Vehiculo {

    // - Variable de clase esta oculta,
    // - No sería posible verla desde otro file o clase
    private boolean motorEncendido = false;

    public boolean getMotorEncendido(){
        return motorEncendido;
    }

    // - Solo se puede ver desde otro archivo o clase encender()
    // - Método que encapsula el encendido
    public void encender(){
        motorEncendido = true;
    }

    // - Solo se puede ver desde otro archivo o clase apagar()
    // - Método que encapsula el apagado
    public void apagar(){
        motorEncendido = false;
    }

}
