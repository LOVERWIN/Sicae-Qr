package com.sistema.servicio;

import com.sistema.modelo.Sesion;
import com.sistema.repositorio.ISesionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SesionServicio implements ISesionServicio {

    @Autowired
    private ISesionRepositorio sesionRepositorio;

    @Override
    public List<Sesion> listarSesiones() {
        return sesionRepositorio.findAll();
    }

    @Override
    public Sesion guardarSesion(Sesion sesion) {
        return sesionRepositorio.save(sesion);
    }

    @Override
    public void eliminarSesionByID(Integer idSesion) {
        sesionRepositorio.deleteById(idSesion);
    }

    @Override
    public Sesion buscarPorId(Integer idSesion) {
        return sesionRepositorio.findById(idSesion).orElse(null);
    }
}
