package com.sistema.servicio;

import com.sistema.modelo.Alumno;
import com.sistema.repositorio.IAlumnosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoServicio implements IAlumnoServicio{

    @Autowired
    private IAlumnosRepositorio iAlumnosRepositorio;

    @Override
    public List<Alumno> listarAlumnos() {
        return this.iAlumnosRepositorio.findAll();
    }

    @Override
    public Alumno guardarAlumno(Alumno alumno) {
        return this.iAlumnosRepositorio.save(alumno);
    }

    @Override
    public void eliminarAlumnoByID(String idAlumno) {
        this.iAlumnosRepositorio.deleteById(idAlumno);
    }

    @Override
    public Alumno buscarPorId(String idAlumno) {
        return this.iAlumnosRepositorio.findById(idAlumno).orElse(null);
    }

    @Override
    public List<Alumno> obtenerAlumnosQueAsistieron(Integer idEvento, String tipoRegistro) {
        return this.iAlumnosRepositorio.obtenerAlumnosQueAsistieron(idEvento, tipoRegistro);
    }
}
