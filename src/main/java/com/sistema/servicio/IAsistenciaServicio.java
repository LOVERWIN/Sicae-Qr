package com.sistema.servicio;

import com.sistema.modelo.Asistencia;

import java.util.List;

public interface IAsistenciaServicio {

     List<Asistencia> listarAsistencias();

     Asistencia guardarAsistencia(Asistencia asistencia);

     void eliminarAsistenciaByID(Integer idAsistencia);

     Asistencia buscarPorId(Integer idAsistencia);

    Asistencia obtenerAsistenciasPorIdAlumnoTipoRegistroYIdEvento(String idAlumno, String tipoRegistro, Integer idEvento);

    int contarAsistenciasPorEventoYTipoRegistro(Integer idEvento, String tipoRegistro);

}
