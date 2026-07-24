package com.testeracademy.utils;

/**
 * Clase utilitaria con métodos relacionados a la validación de alumnos.
 */
public class AlumnoUtils {

    /**
     * Valida que un nombre cumpla las siguientes reglas:
     *     - No sea nulo.
     *     - Tenga entre 2 y 50 caracteres.
     *     - Contenga únicamente letras y espacios.
     * @param nombre Nombre a validar.
     * @return {@code true} si el nombre es válido; {@code false} en caso contrario.
     */
    public static boolean nombreValido(String nombre) {

        if (nombre == null) {
            return false;
        }

        nombre = nombre.trim();

        if (nombre.length() < 2 || nombre.length() > 50) {
            return false;
        }

        for (char letra : nombre.toCharArray()) {

            if (!Character.isLetter(letra) && letra != ' ') {
                return false;
            }

        }

        return true;
    }

}
