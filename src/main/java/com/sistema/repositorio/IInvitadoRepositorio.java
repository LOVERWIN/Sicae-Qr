package com.sistema.repositorio;

import com.sistema.modelo.Invitado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInvitadoRepositorio extends JpaRepository<Invitado,Integer> {
}
