package com.sistema.servicio;

import com.sistema.modelo.Justificacion;
import com.sistema.repositorio.IJustificacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JustificacionServicio implements IJustificacionServicio {
    @Autowired
    private IJustificacionRepositorio iJustificacionRepositorio;

    @Override
    public List<Justificacion> listarTipoJustificacion() {
        return this.iJustificacionRepositorio.findAll();
    }

    @Override
    public Justificacion guardarTipoJustificacion(Justificacion justificacion) {
        return this.iJustificacionRepositorio.save(justificacion);
    }

    @Override
    public void eliminarTipoJustificacionByID(Integer idJustificacion) {
        this.iJustificacionRepositorio.deleteById(idJustificacion);
    }

    @Override
    public Justificacion buscarPorId(Integer idJustificacion) {
        return this.iJustificacionRepositorio.findById(idJustificacion).orElse(null);
    }
}
