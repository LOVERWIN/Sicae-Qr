package com.sistema.controlador;

import com.sistema.excepcion.RecursoNoEncontradoExcepcion;
import com.sistema.modelo.Producto;
import com.sistema.servicio.ProductoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping({"Sistema-Inventario-app","http://192.168.7.2:4200/productos"})
//@CrossOrigin(value = {"http://localhost:4200"})
public class ProductoControlador {

    private static final Logger logger = LoggerFactory.getLogger(ProductoControlador.class);
    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping("/productos")
    public List<Producto> obtenerProductos(){
         List<Producto> productos = this.productoServicio.listarProductos();
         logger.info("Productos obtenidos");
         return productos;
    }
    //Este metodo tambien sirve para actualizar si el id no es nulo
    @PostMapping("/productos")
    public Producto agregarProducto(@RequestBody Producto producto){
        logger.info("Producto a Agregar: " +producto);
        return this.productoServicio.guardarProducto(producto);

    }
    @PutMapping("/productos/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable int id,
                                                       @RequestBody Producto producto){
        Producto producto1 = productoServicio.buscarPorId(id);
        if (producto1 == null)
            throw new RecursoNoEncontradoExcepcion("No se encontro el id");
        producto1.setNombre(producto.getNombre());
        producto1.setCantidad(producto.getCantidad());
        producto1.setPrecio(producto.getPrecio());
        this.productoServicio.guardarProducto(producto1);
        return ResponseEntity.ok(producto1);
    }
    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarProductoPorId(@PathVariable int id){
        Producto producto = this.productoServicio.buscarPorId(id);
        if (producto == null){
            throw new RecursoNoEncontradoExcepcion("No se encontro el id: "+id);
        }
        this.productoServicio.eliminarProductoByID(producto.getIdProducto());
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("Eliminado",Boolean.TRUE);
        logger.info("Producto Eliminado");
        return ResponseEntity.ok(respuesta);
    }
    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable int id){
        Producto producto = productoServicio.buscarPorId(id);
        if (producto != null){
            return ResponseEntity.ok(producto);
        }
         throw new RecursoNoEncontradoExcepcion("No se encontro el Id: "+id);

    }



}
