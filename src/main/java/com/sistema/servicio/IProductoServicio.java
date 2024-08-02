package com.sistema.servicio;

import com.sistema.modelo.Producto;

import java.util.List;

public interface IProductoServicio {

    public List<Producto> listarProductos();

    public Producto guardarProducto(Producto producto);

    public void eliminarProductoByID(Integer idProducto);

    public Producto buscarPorId(Integer IdProducto);
}
