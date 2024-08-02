package com.sistema.servicio;

import com.sistema.modelo.Invitado;

import java.util.List;

public interface IInvitadoServicio {

    public List<Invitado> listarInvitados();

    public Invitado guardarInvitados(Invitado invitado);

    public void eliminarInvitadoByID(Integer invitado);

    public Invitado buscarPorId(Integer idInvitado);
}
