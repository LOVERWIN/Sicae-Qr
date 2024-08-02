package com.sistema.servicio;

import com.sistema.modelo.Trabajador;
import com.sistema.repositorio.ITrabajadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrabajadorServicio implements ITrabajadorServicio{
    @Autowired
    private ITrabajadorRepositorio iTrabajadorRepositorio;
    @Override
    public List<Trabajador> listarTrabajador() {
        return this.iTrabajadorRepositorio.findAll();
    }

    @Override
    public Trabajador guardarTrabajador(Trabajador trabajador) {
        return this.iTrabajadorRepositorio.save(trabajador);
    }

    @Override
    public void eliminarTrabajadorByID(Integer idTrabajador) {
        this.iTrabajadorRepositorio.deleteById(idTrabajador);
    }

    @Override
    public Trabajador buscarPorId(Integer idTrabajador) {
        return this.iTrabajadorRepositorio.findById(idTrabajador).orElse(null);
    }
}
