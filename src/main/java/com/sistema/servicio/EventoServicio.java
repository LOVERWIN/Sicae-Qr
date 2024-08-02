package com.sistema.servicio;

import com.sistema.modelo.Evento;
import com.sistema.repositorio.IEventoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoServicio implements IEventoServicio{

    @Autowired
    private IEventoRepositorio iEventoRepositorio;

    @Override
    public List<Evento> listarEvento() {
        return this.iEventoRepositorio.findAll();
    }

    @Override
    public Evento guardarEvento(Evento evento) {
        return this.iEventoRepositorio.save(evento);
    }

    @Override
    public void eliminarEventoByID(Integer idEvento) {
        this.iEventoRepositorio.deleteById(idEvento);
    }

    @Override
    public Evento buscarPorId(Integer idEvento) {
        return this.iEventoRepositorio.findById(idEvento).orElse(null);
    }
}
