package com.sistema.servicio;

import com.sistema.modelo.Genero;

import java.util.List;

public interface IGeneroServicio {

    List<Genero> listarGeneros();

    Genero guardarGenero(Genero genero);

    void eliminarGeneroByID(Integer idGenero);

    Genero buscarPorId(Integer idGenero);
}
