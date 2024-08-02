package com.sistema.servicio;

import com.sistema.modelo.Horario;

import java.util.List;

public interface IHorarioServicio {

    List<Horario> listarHorarios();

    Horario guardarHorario(Horario horario);

    void eliminarHorarioByID(Integer idHorario);

    Horario buscarPorId(Integer idHorario);
}
