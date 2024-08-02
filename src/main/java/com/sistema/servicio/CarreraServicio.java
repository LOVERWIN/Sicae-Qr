package com.sistema.servicio;

import com.sistema.modelo.Carrera;
import com.sistema.repositorio.ICarreraRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarreraServicio implements ICarreraServicio {

    @Autowired
    private ICarreraRepositorio carreraRepositorio;

    @Override
    public List<Carrera> listarCarreras() {
        return carreraRepositorio.findAll();
    }

    @Override
    public Carrera guardarCarrera(Carrera carrera) {
        return carreraRepositorio.save(carrera);
    }

    @Override
    public void eliminarCarreraByID(Integer idCarrera) {
        carreraRepositorio.deleteById(idCarrera);
    }

    @Override
    public Carrera buscarPorId(Integer idCarrera) {
        return carreraRepositorio.findById(idCarrera).orElse(null);
    }
}
