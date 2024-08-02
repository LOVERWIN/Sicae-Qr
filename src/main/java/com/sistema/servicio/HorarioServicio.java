package com.sistema.servicio;

import com.sistema.modelo.Horario;
import com.sistema.repositorio.IHorarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioServicio implements IHorarioServicio {

    @Autowired
    private IHorarioRepositorio horarioRepositorio;

    @Override
    public List<Horario> listarHorarios() {
        return horarioRepositorio.findAll();
    }

    @Override
    public Horario guardarHorario(Horario horario) {
        return horarioRepositorio.save(horario);
    }

    @Override
    public void eliminarHorarioByID(Integer idHorario) {
        horarioRepositorio.deleteById(idHorario);
    }

    @Override
    public Horario buscarPorId(Integer idHorario) {
        return horarioRepositorio.findById(idHorario).orElse(null);
    }
}
