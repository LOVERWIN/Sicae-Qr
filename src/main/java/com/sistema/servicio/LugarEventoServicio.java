package com.sistema.servicio;

import com.sistema.modelo.LugarEvento;
import com.sistema.repositorio.ILugarEventoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LugarEventoServicio implements ILugarEventoServicio{
    @Autowired
    private ILugarEventoRepositorio iLugarEventoRepositorio;
    @Override
    public List<LugarEvento> listarLugarEvento() {
        return this.iLugarEventoRepositorio.findAll();

    }

    @Override
    public LugarEvento guardarLugarEvento(LugarEvento idLugar) {
        return this.iLugarEventoRepositorio.save(idLugar);
    }

    @Override
    public void eliminarLugarEventoByID(Integer idLugar) {
        this.iLugarEventoRepositorio.deleteById(idLugar);

    }

    @Override
    public LugarEvento buscarPorId(Integer idLugar) {
        return this.iLugarEventoRepositorio.findById(idLugar).orElse(null);
    }
}
