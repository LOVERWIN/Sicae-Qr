package com.sistema.servicio;

import com.sistema.modelo.Producto;
import com.sistema.modelo.TipoInvitado;

import java.util.List;

public interface ITipoInvitadoServicio {

    public List<TipoInvitado> listarTipoInvitados();

    public TipoInvitado guardarTipoInvitado(TipoInvitado tipoInvitado);

    public void eliminarTipoInvitadoByID(Integer idTipoInvitado);

    public TipoInvitado buscarPorId(Integer idTipoInvitado);

}
