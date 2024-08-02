package com.sistema.servicio;

import com.sistema.modelo.Genero;
import com.sistema.repositorio.IGeneroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroServicio implements IGeneroServicio {

    @Autowired
    private IGeneroRepositorio generoRepositorio;

    @Override
    public List<Genero> listarGeneros() {
        return generoRepositorio.findAll();
    }

    @Override
    public Genero guardarGenero(Genero genero) {
        return generoRepositorio.save(genero);
    }

    @Override
    public void eliminarGeneroByID(Integer idGenero) {
        generoRepositorio.deleteById(idGenero);
    }

    @Override
    public Genero buscarPorId(Integer idGenero) {
        return generoRepositorio.findById(idGenero).orElse(null);
    }
}
