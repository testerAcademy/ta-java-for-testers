package cap05.metodosInvocarDesdeOtraClase.utils;

public class Validaciones {

    /**
     * Valida que un texto contenga únicamente letras y espacios.
     *
     * Reglas:
     * - Solo letras (mayúsculas o minúsculas).
     * - Se permiten espacios.
     * - No se permiten números.
     * - No se permiten caracteres especiales.
     * - No se permite null ni cadenas vacías.
     *
     * @param texto Texto a validar.
     * @return true si el texto es válido; false en caso contrario.
     */
    public static boolean validarSoloTexto(String texto) {

        if (texto == null || texto.trim().isEmpty()) {
            return false;
        }

        return texto.matches("[A-Za-z ]+");
    }

}
