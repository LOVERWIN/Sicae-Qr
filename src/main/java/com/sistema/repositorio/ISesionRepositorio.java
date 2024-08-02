package com.sistema.repositorio;

import com.sistema.modelo.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISesionRepositorio extends JpaRepository<Sesion, Integer> {
    // Puedes agregar consultas personalizadas si es necesario
}
