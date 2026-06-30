package cap05.metodos;

public class Ej01_MetodosVoid {
    public static void main(String[] args) {
        saludo();
        saludo("Kero");
    }

    private static void saludo(){
        System.out.println("Hola como estas");
        System.out.println("Bienvenido al curso: Java For Testers");
        System.out.println("Tu camino como QA Automation, empieza hoy...");
    }

    private static void saludo(String nombre) {
        System.out.println("Hola como estas " + nombre);
        System.out.println("Bienvenido al curso: Java For Testers");
        System.out.println("Tu camino como QA Automation, empieza hoy...");

    }
}
