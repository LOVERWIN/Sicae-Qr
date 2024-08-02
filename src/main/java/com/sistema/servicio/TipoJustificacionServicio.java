package com.sistema.servicio;

import com.sistema.modelo.TipoJustificacion;
import com.sistema.repositorio.ITipoJustificacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TipoJustificacionServicio implements ITipoJustificacionServicio{
    @Autowired
    private ITipoJustificacionRepositorio iTipoJustificacionRepositorio;
    @Override
    public List<TipoJustificacion> listarTipoJustificacion() {
        return this.iTipoJustificacionRepositorio.findAll();
    }

    @Override
    public TipoJustificacion guardarTipoJustificacion(TipoJustificacion tipoJustificacion) {
        return this.iTipoJustificacionRepositorio.save(tipoJustificacion);
    }

    @Override
    public void eliminarTipoJustificacionByID(Integer idTipoJustificacion) {
        this.iTipoJustificacionRepositorio.deleteById(idTipoJustificacion);
    }

    @Override
    public TipoJustificacion buscarPorId(Integer idTipoJustificacion) {
        return this.iTipoJustificacionRepositorio.findById(idTipoJustificacion).orElse(null);
    }
}
