package com.sistema.servicio;

import com.sistema.modelo.Campus;

import java.util.List;

public interface ICampusServicio {

    List<Campus> listarCampus();

    Campus guardarCampus(Campus campus);

    void eliminarCampusByID(Integer idCampus);

    Campus buscarPorId(Integer idCampus);
}
