package com.sistema.repositorio;

import com.sistema.modelo.LugarEvento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILugarEventoRepositorio extends JpaRepository<LugarEvento,Integer> {
}
