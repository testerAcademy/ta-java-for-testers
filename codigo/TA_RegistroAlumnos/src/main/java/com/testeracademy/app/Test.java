package com.testeracademy.app;

import com.testeracademy.dao.AlumnoDAO;
import com.testeracademy.dto.AlumnoDTO;
import com.testeracademy.dto.PersonaDTO;
import com.testeracademy.utils.AlumnoUtils;

public class Test {
    public static void main(String[] args) {
        //testPersona();
        //testAlumno();
        //testGuardarAlumnoDAO();
        //testObtenerAlumnoXId(1);
        //testObtenerAlumnoXId(11);
        testUtils();
    }

    public static void testAlumno(){
        AlumnoDTO alumnoDTO = new AlumnoDTO();
        alumnoDTO.setId(1);
        alumnoDTO.setNombre("Dave");
        alumnoDTO.setApellido("Chavez");
        alumnoDTO.setEdad(30);
        alumnoDTO.setCurso("Java For Testers");
        System.out.println(alumnoDTO.toString());

    }

    public static void testPersona(){
        PersonaDTO personaDto = new PersonaDTO();
        personaDto.setApellido("Avila");
        personaDto.setNombre("David");
        personaDto.setEdad(30);
        System.out.println(personaDto.toString());
        personaDto.setNombre("Dave Micho");
        System.out.println(personaDto.toString());

        PersonaDTO personaDTO2 = new PersonaDTO("Fer", "Mesa", 29);
        personaDTO2.setNombre("MaFeR");
        System.out.println(personaDTO2);
    }

    public static void testGuardarAlumnoDAO(){
        AlumnoDTO alumnoDTO = new AlumnoDTO();
        AlumnoDAO alumnoDAO = new AlumnoDAO();

        int siguienteIdAlumno = alumnoDAO.obtenerSiguienteId();
        alumnoDTO.setId(siguienteIdAlumno);
        alumnoDTO.setNombre("Dave");
        alumnoDTO.setApellido("Chavez");
        alumnoDTO.setEdad(30);
        alumnoDTO.setCurso("Java For Testers");
        System.out.println(alumnoDTO.toString());

        alumnoDAO.guardar(alumnoDTO);
        System.out.println(alumnoDAO.obtenerAlumnos());

    }

    public static void testObtenerAlumnoXId(int id){
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        AlumnoDTO alumno = alumnoDAO.consultarPorId(id);
        System.out.println("Alumno con id: '" + id + "' datos: \n" + alumno);
    }

    public static void testUtils(){
        AlumnoDTO alumnoDTO = new AlumnoDTO();
        AlumnoDAO alumnoDAO = new AlumnoDAO();

        int siguienteIdAlumno = alumnoDAO.obtenerSiguienteId();
        alumnoDTO.setId(siguienteIdAlumno);
        alumnoDTO.setNombre("Dave777");
        alumnoDTO.setApellido("Chavez");
        alumnoDTO.setEdad(30);
        alumnoDTO.setCurso("Java For Testers");
        System.out.println(alumnoDTO.toString());

        //valida nombre
        boolean esNombreValido = AlumnoUtils.nombreValido(alumnoDTO.getNombre());
        if (!esNombreValido){
            System.out.println("Nombre INVALIDO");
            return;
        }

        alumnoDAO.guardar(alumnoDTO);
        System.out.println(alumnoDAO.obtenerAlumnos());

    }

}
