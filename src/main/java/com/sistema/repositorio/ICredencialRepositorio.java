package com.sistema.repositorio;

import com.sistema.modelo.Credencial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICredencialRepositorio extends JpaRepository<Credencial,Integer> {
    Credencial findByEmail(String email);
}
