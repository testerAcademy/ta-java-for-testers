package com.testeracademy.data;

import com.testeracademy.dto.AlumnoDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Simula una fuente de datos en memoria.
 */
public class DataManager {

    private static final List<AlumnoDTO> ALUMNOS = new ArrayList<>();

    static {
        ALUMNOS.add(new AlumnoDTO(1, "Ana", "López", 22, "Java"));
        ALUMNOS.add(new AlumnoDTO(2, "Carlos", "Pérez", 25, "Testing"));
        ALUMNOS.add(new AlumnoDTO(3, "Zoe", "Chávez", 18, "Java"));
        ALUMNOS.add(new AlumnoDTO(4, "Josy", "Ávila", 20, "Selenium"));
        ALUMNOS.add(new AlumnoDTO(5, "María", "García", 24, "API Testing"));
        ALUMNOS.add(new AlumnoDTO(6, "Luis", "Martínez", 27, "Java"));
        ALUMNOS.add(new AlumnoDTO(7, "Sofía", "Ramírez", 21, "Testing"));
        ALUMNOS.add(new AlumnoDTO(8, "Pedro", "Torres", 29, "Selenium"));
        ALUMNOS.add(new AlumnoDTO(9, "Elena", "Flores", 23, "Java"));
        ALUMNOS.add(new AlumnoDTO(10, "Diego", "Sánchez", 26, "Performance"));
    }

    private DataManager() {
    }

    public static List<AlumnoDTO> obtenerAlumnos() {
        return ALUMNOS;
    }
}
