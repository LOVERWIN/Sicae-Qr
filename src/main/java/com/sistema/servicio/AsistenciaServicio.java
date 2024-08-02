package com.sistema.servicio;

import com.sistema.modelo.Asistencia;
import com.sistema.repositorio.IAsistenciaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AsistenciaServicio implements IAsistenciaServicio{
    @Autowired
    private IAsistenciaRepositorio iAsistenciaRepositorio;
    @Override
    public List<Asistencia> listarAsistencias() {
        return this.iAsistenciaRepositorio.findAll();
    }

    @Override
    public Asistencia guardarAsistencia(Asistencia asistencia) {
        return this.iAsistenciaRepositorio.save(asistencia);
    }

    @Override
    public void eliminarAsistenciaByID(Integer idAsistencia) {
        this.iAsistenciaRepositorio.deleteById(idAsistencia);
    }

    @Override
    public Asistencia buscarPorId(Integer idAsistencia) {
        return this.iAsistenciaRepositorio.findById(idAsistencia).orElse(null);
    }

    @Override
    public Asistencia obtenerAsistenciasPorIdAlumnoTipoRegistroYIdEvento(String idAlumno, String tipoRegistro, Integer idEvento) {
        return this.iAsistenciaRepositorio.findByIdAlumnoAndTipoRegistroAndIdEvento(idAlumno, tipoRegistro, idEvento);
    }

    @Override
    public int contarAsistenciasPorEventoYTipoRegistro(Integer idEvento, String tipoRegistro) {
        return this.iAsistenciaRepositorio.countByEventoAndTipoRegistro(idEvento, tipoRegistro);
    }
}
