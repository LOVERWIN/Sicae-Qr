package com.sistema.repositorio;

import com.sistema.modelo.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHorarioRepositorio extends JpaRepository<Horario, Integer> {
    // Puedes agregar consultas personalizadas si es necesario
}
