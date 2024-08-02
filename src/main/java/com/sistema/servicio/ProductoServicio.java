package com.sistema.servicio;

import com.sistema.modelo.Producto;
import com.sistema.repositorio.IProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicio implements IProductoServicio{
    @Autowired
    private IProductoRepositorio iProductoRepositorio;

    @Override
    public List<Producto> listarProductos() {
        return this.iProductoRepositorio.findAll();
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return this.iProductoRepositorio.save(producto);
    }

    @Override
    public void eliminarProductoByID(Integer idProducto) {
        this.iProductoRepositorio.deleteById(idProducto);
    }

    @Override
    public Producto buscarPorId(Integer IdProducto) {
        return this.iProductoRepositorio.findById(IdProducto).orElse(null);
    }
}
