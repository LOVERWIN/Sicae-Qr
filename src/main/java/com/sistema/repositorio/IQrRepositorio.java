package com.sistema.repositorio;

import com.sistema.modelo.Qr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQrRepositorio extends JpaRepository<Qr, Integer> {
    // Puedes agregar consultas personalizadas si es necesario
}
