package com.sistema.repositorio;

import com.sistema.modelo.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAlumnosRepositorio extends JpaRepository<Alumno,String> {
    @Query("SELECT DISTINCT al FROM Asistencia a JOIN Alumno al ON a.idAlumno = al.idAlumno " +
            "WHERE a.idEvento = :idEvento AND a.tipoRegistro = :tipoRegistro")
    List<Alumno> obtenerAlumnosQueAsistieron(Integer idEvento, String tipoRegistro);

}
