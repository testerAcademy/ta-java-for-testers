package com.testeracademy.dto;

/**
 * DTO base con los datos generales de una persona.
 */
public class PersonaDTO {

    private String nombre;
    private String apellido;
    private int edad;

    public PersonaDTO() {
    }

    public PersonaDTO(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
