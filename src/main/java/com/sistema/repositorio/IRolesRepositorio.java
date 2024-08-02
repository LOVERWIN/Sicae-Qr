package com.sistema.repositorio;

import com.sistema.modelo.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolesRepositorio extends JpaRepository<Roles, Integer> {
    // Puedes agregar consultas personalizadas si es necesario
}
