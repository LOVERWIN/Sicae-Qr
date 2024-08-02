package com.sistema.repositorio;

import com.sistema.modelo.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEventoRepositorio extends JpaRepository<Evento,Integer> {
}
