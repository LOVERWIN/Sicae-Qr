package com.sistema.servicio;

import com.sistema.modelo.Roles;

import java.util.List;

public interface IRolesServicio {

    List<Roles> listarRoles();

    Roles guardarRoles(Roles roles);

    void eliminarRolesByID(Integer idRoles);

    Roles buscarPorId(Integer idRoles);
}
