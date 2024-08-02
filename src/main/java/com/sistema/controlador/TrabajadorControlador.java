package com.sistema.controlador;

import com.sistema.modelo.Trabajador;
import com.sistema.servicio.TrabajadorServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Sistema-Inventario-app")
//@CrossOrigin(value = {"http://localhost:4200"})
public class TrabajadorControlador {

    private static final Logger logger = LoggerFactory.getLogger(TrabajadorControlador.class);

    @Autowired
    private TrabajadorServicio trabajadorServicio;

    @GetMapping("/trabajadores")
    public List<Trabajador> obtenerTrabajadores() {
        List<Trabajador> trabajadores = this.trabajadorServicio.listarTrabajador();
        logger.info("Trabajadores obtenidos");
        return trabajadores;
    }

    @PostMapping("/trabajadores")
    public Trabajador agregarTrabajador(@RequestBody Trabajador trabajador) {
        logger.info("Trabajador a agregar: " + trabajador);
        return this.trabajadorServicio.guardarTrabajador(trabajador);
    }

    @DeleteMapping("/trabajadores/{idTrabajador}")
    public void eliminarTrabajadorPorId(@PathVariable Integer idTrabajador) {
        trabajadorServicio.eliminarTrabajadorByID(idTrabajador);
        logger.info("Trabajador eliminado");
    }

    @GetMapping("/trabajadores/{idTrabajador}")
    public ResponseEntity<Trabajador> obtenerTrabajadorPorId(@PathVariable Integer idTrabajador) {
        Trabajador trabajador = trabajadorServicio.buscarPorId(idTrabajador);
        if (trabajador != null) {
            return ResponseEntity.ok(trabajador);
        }
        return ResponseEntity.notFound().build();
    }
}
