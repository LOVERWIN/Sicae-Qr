package com.sistema.repositorio;

import com.sistema.modelo.TipoJustificacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipoJustificacionRepositorio extends JpaRepository<TipoJustificacion,Integer> {
}
