package com.sistema.servicio;

import com.sistema.modelo.Sesion;

import java.util.List;

public interface ISesionServicio {

    List<Sesion> listarSesiones();

    Sesion guardarSesion(Sesion sesion);

    void eliminarSesionByID(Integer idSesion);

    Sesion buscarPorId(Integer idSesion);
}
