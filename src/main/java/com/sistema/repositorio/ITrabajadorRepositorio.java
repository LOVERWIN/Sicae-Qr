package com.sistema.repositorio;

import com.sistema.modelo.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITrabajadorRepositorio extends JpaRepository<Trabajador,Integer> {
}
