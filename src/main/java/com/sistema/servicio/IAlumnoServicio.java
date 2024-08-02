package com.sistema.servicio;

import com.sistema.modelo.Alumno;
import com.sistema.modelo.LugarEvento;

import java.util.List;

public interface IAlumnoServicio {

    public List<Alumno> listarAlumnos();

    public Alumno guardarAlumno(Alumno alumno);

    public void eliminarAlumnoByID(String idAlumno);

    public Alumno buscarPorId(String idAlumno);

    public List<Alumno> obtenerAlumnosQueAsistieron(Integer idEvento, String tipoRegistro);
}
