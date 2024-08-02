package com.sistema.servicio;

import com.sistema.modelo.Facultad;

import java.util.List;

public interface IFacultadServicio {

    List<Facultad> listarFacultades();

    Facultad guardarFacultad(Facultad facultad);

    void eliminarFacultadByID(Integer idFacultad);

    Facultad buscarPorId(Integer idFacultad);
}
