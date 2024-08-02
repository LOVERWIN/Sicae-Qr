package com.sistema.servicio;

import com.sistema.modelo.Campus;
import com.sistema.repositorio.ICampusRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampusServicio implements ICampusServicio {

    @Autowired
    private ICampusRepositorio campusRepositorio;

    @Override
    public List<Campus> listarCampus() {
        return campusRepositorio.findAll();
    }

    @Override
    public Campus guardarCampus(Campus campus) {
        return campusRepositorio.save(campus);
    }

    @Override
    public void eliminarCampusByID(Integer idCampus) {
        campusRepositorio.deleteById(idCampus);
    }

    @Override
    public Campus buscarPorId(Integer idCampus) {
        return campusRepositorio.findById(idCampus).orElse(null);
    }
}
