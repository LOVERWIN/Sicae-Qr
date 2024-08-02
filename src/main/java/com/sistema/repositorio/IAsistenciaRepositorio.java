package com.sistema.repositorio;

import com.sistema.modelo.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAsistenciaRepositorio extends JpaRepository<Asistencia,Integer> {
    public Asistencia findByIdAlumnoAndTipoRegistroAndIdEvento(String idAlumno, String tipoRegistro, Integer idEvento);
    @Query("SELECT COALESCE(COUNT(a), 0) FROM Asistencia a WHERE a.idEvento = :idEvento AND a.tipoRegistro = :tipoRegistro")
    int countByEventoAndTipoRegistro(Integer idEvento, String tipoRegistro);

    List<Asistencia> findByIdEventoAndTipoRegistro(Integer idEvento, String tipoRegistro);
}


