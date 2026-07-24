package com.testeracademy.dto;

/**
 * DTO de alumno.
 * Hereda los datos generales de PersonaDTO.
 */
public class AlumnoDTO extends PersonaDTO {

    private int id;
    private String curso;

    public AlumnoDTO() {
    }

    public AlumnoDTO(int id, String nombre, String apellido, int edad, String curso) {
        super(nombre, apellido, edad);
        this.id = id;
        this.curso = curso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "ID: " + getId()
                + " | Nombre: " + getNombre() + " " + getApellido()
                + " | Edad: " + getEdad()
                + " | Curso: " + curso;
    }
}
