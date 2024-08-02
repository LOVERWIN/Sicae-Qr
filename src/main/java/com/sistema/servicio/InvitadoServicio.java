package com.sistema.servicio;

import com.sistema.modelo.Invitado;
import com.sistema.repositorio.IInvitadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvitadoServicio implements IInvitadoServicio{
    @Autowired
    private IInvitadoRepositorio iInvitadoRepositorio;
    @Override
    public List<Invitado> listarInvitados() {
        return this.iInvitadoRepositorio.findAll();
    }

    @Override
    public Invitado guardarInvitados(Invitado invitado) {
        return this.iInvitadoRepositorio.save(invitado);
    }

    @Override
    public void eliminarInvitadoByID(Integer invitado) {
        this.iInvitadoRepositorio.deleteById(invitado);
    }

    @Override
    public Invitado buscarPorId(Integer idInvitado) {
        return this.iInvitadoRepositorio.findById(idInvitado).orElse(null);
    }
}
