package com.sistema.repositorio;

import com.sistema.modelo.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGeneroRepositorio extends JpaRepository<Genero, Integer> {
    // Puedes agregar consultas personalizadas si es necesario
}
