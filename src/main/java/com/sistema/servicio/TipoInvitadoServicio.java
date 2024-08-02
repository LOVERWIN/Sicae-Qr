package com.sistema.servicio;

import com.sistema.modelo.TipoInvitado;
import com.sistema.repositorio.ITipoInvitadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TipoInvitadoServicio implements ITipoInvitadoServicio{
    @Autowired
    private ITipoInvitadoRepositorio iTipoInvitadoRepositorio;

    @Override
    public List<TipoInvitado> listarTipoInvitados() {
        return this.iTipoInvitadoRepositorio.findAll();
    }

    @Override
    public TipoInvitado guardarTipoInvitado(TipoInvitado tipoInvitado) {
        return this.iTipoInvitadoRepositorio.save(tipoInvitado);
    }

    @Override
    public void eliminarTipoInvitadoByID(Integer idTipoInvitado) {
        this.iTipoInvitadoRepositorio.deleteById(idTipoInvitado);
    }

    @Override
    public TipoInvitado buscarPorId(Integer idTipoInvitado) {
        return this.iTipoInvitadoRepositorio.findById(idTipoInvitado).orElse(null);
    }
}
