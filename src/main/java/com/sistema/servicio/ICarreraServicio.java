package com.sistema.servicio;

import com.sistema.modelo.Carrera;

import java.util.List;

public interface ICarreraServicio {

    List<Carrera> listarCarreras();

    Carrera guardarCarrera(Carrera carrera);

    void eliminarCarreraByID(Integer idCarrera);

    Carrera buscarPorId(Integer idCarrera);
}
