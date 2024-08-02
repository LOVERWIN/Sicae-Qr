package com.sistema.repositorio;

import com.sistema.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepositorio extends JpaRepository<Producto,Integer> {
}
