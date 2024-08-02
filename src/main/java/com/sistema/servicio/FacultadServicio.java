package com.sistema.servicio;

import com.sistema.modelo.Facultad;
import com.sistema.repositorio.IFacultadRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultadServicio implements IFacultadServicio {

    @Autowired
    private IFacultadRepositorio facultadRepositorio;

    @Override
    public List<Facultad> listarFacultades() {
        return facultadRepositorio.findAll();
    }

    @Override
    public Facultad guardarFacultad(Facultad facultad) {
        return facultadRepositorio.save(facultad);
    }

    @Override
    public void eliminarFacultadByID(Integer idFacultad) {
        facultadRepositorio.deleteById(idFacultad);
    }

    @Override
    public Facultad buscarPorId(Integer idFacultad) {
        return facultadRepositorio.findById(idFacultad).orElse(null);
    }
}
