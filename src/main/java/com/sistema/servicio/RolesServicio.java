package com.sistema.servicio;

import com.sistema.modelo.Roles;
import com.sistema.repositorio.IRolesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesServicio implements IRolesServicio {

    @Autowired
    private IRolesRepositorio rolesRepositorio;

    @Override
    public List<Roles> listarRoles() {
        return rolesRepositorio.findAll();
    }

    @Override
    public Roles guardarRoles(Roles roles) {
        return rolesRepositorio.save(roles);
    }

    @Override
    public void eliminarRolesByID(Integer idRoles) {
        rolesRepositorio.deleteById(idRoles);
    }

    @Override
    public Roles buscarPorId(Integer idRoles) {
        return rolesRepositorio.findById(idRoles).orElse(null);
    }
}
