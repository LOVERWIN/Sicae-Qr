package com.sistema.repositorio;

import com.sistema.modelo.Campus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICampusRepositorio extends JpaRepository<Campus, Integer> {
    // Puedes agregar consultas personalizadas si es necesario
}
