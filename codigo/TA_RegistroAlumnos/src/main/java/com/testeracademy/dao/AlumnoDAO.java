package com.testeracademy.dao;

import com.testeracademy.data.DataManager;
import com.testeracademy.dto.AlumnoDTO;

import java.util.List;

/**
 * Clase encargada de guardar y consultar alumnos.
 */
public class AlumnoDAO {

    private List<AlumnoDTO> alumnos = DataManager.obtenerAlumnos();

    public void guardar(AlumnoDTO alumno) {
        alumnos.add(alumno);
    }

    public AlumnoDTO consultarPorId(int id) {
        for (AlumnoDTO alumno : alumnos) {
            if (alumno.getId() == id) {
                return alumno;
            }
        }

        return null;
    }

    public int obtenerSiguienteId() {
        return alumnos.size() + 1;
    }
}
