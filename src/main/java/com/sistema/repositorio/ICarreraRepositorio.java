package com.sistema.repositorio;

import com.sistema.modelo.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarreraRepositorio extends JpaRepository<Carrera, Integer> {
    // Puedes agregar consultas personalizadas si es necesario
}
