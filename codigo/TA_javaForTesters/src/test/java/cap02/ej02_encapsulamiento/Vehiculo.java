package cap02.ej02_encapsulamiento;

public class Vehiculo {

    // - Variable de clase esta oculta,
    // - No sería posible verla desde otro file o clase
    private boolean motorEncendido = false;

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
