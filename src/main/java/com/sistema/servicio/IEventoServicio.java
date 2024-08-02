package com.sistema.servicio;

import com.sistema.modelo.Alumno;
import com.sistema.modelo.Evento;

import java.util.List;

public interface IEventoServicio {

    public List<Evento> listarEvento();

    public Evento guardarEvento(Evento evento);

    public void eliminarEventoByID(Integer idEvento);

    public Evento buscarPorId(Integer idEvento);
}
