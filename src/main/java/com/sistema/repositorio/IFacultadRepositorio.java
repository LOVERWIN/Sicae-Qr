package com.sistema.repositorio;

import com.sistema.modelo.Facultad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacultadRepositorio extends JpaRepository<Facultad, Integer> {
    // Puedes agregar consultas personalizadas si es necesario
}
