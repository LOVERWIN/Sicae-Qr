package com.sistema.repositorio;

import com.sistema.modelo.Justificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJustificacionRepositorio extends JpaRepository<Justificacion,Integer> {
}
