package com.testeracademy.app;

import com.testeracademy.dao.AlumnoDAO;
import com.testeracademy.dto.AlumnoDTO;
import com.testeracademy.utils.AlumnoUtils;
import com.testeracademy.utils.ConsoleUtils;

/**
 * Punto de entrada del programa.
 */
public class Main {

    private static AlumnoDAO ALUMNO_DAO = new AlumnoDAO();

    public static void main(String[] args) {

        boolean programaActivo = true;

        while (programaActivo) {
            mostrarMenu();

            int opcion = ConsoleUtils.leerNumero("Selecciona una opción: ");

            switch (opcion) {
                case 1:
                    crearAlumno();
                    programaActivo = preguntarSiContinua();
                    break;

                case 2:
                    consultarAlumno();
                    programaActivo = preguntarSiContinua();
                    break;

                case 3:
                    programaActivo = false;
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }

        System.out.println("Programa finalizado. ¡Hasta pronto!");
        ConsoleUtils.terminarScanner();
    }

    private static void mostrarMenu() {
        System.out.println();
        System.out.println("===== REGISTRO DE ALUMNOS =====");
        System.out.println("1. Crear alumno");
        System.out.println("2. Consultar alumno");
        System.out.println("3. Salir");
    }

    private static void crearAlumno() {
        System.out.println();
        System.out.println("----- CREAR ALUMNO -----");

        int id = ALUMNO_DAO.obtenerSiguienteId();

        System.out.print("Nombre: ");
        String nombre = ConsoleUtils.ingresarTexto();

        if (!AlumnoUtils.nombreValido(nombre)) {
            System.out.println("Nombre inválido.");
            return;
        }

        System.out.print("Apellido: ");
        String apellido = ConsoleUtils.ingresarTexto();

        int edad = ConsoleUtils.leerNumero("Edad: ");

        System.out.print("Curso: ");
        String curso = ConsoleUtils.ingresarTexto();

        AlumnoDTO alumno = new AlumnoDTO(id, nombre, apellido, edad, curso);

        ALUMNO_DAO.guardar(alumno);

        System.out.println();
        System.out.println("Alumno guardado correctamente.");
        System.out.println(alumno);
    }

    private static void consultarAlumno() {
        System.out.println();
        System.out.println("----- CONSULTAR ALUMNO -----");

        int id = ConsoleUtils.leerNumero("Ingresa el ID del alumno: ");

        AlumnoDTO alumno = ALUMNO_DAO.consultarPorId(id);

        if (alumno != null) {
            System.out.println("Alumno encontrado:");
            System.out.println(alumno);
        } else {
            System.out.println("No existe un alumno con el ID " + id + ".");
        }
    }

    private static boolean preguntarSiContinua() {
        System.out.println();
        System.out.println("1. Regresar al menú principal");
        System.out.println("2. Salir");

        int opcion = ConsoleUtils.leerNumero("Selecciona una opción: ");

        return opcion == 1;
    }
}
