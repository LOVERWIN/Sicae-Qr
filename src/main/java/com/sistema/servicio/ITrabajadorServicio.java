package com.sistema.servicio;

import com.sistema.modelo.TipoInvitado;
import com.sistema.modelo.Trabajador;

import java.util.List;

public interface ITrabajadorServicio {

    public List<Trabajador> listarTrabajador();

    public Trabajador guardarTrabajador(Trabajador trabajador);

    public void eliminarTrabajadorByID(Integer idTrabajador);

    public Trabajador buscarPorId(Integer idTrabajador);
}
