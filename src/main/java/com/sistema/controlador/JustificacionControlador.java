package com.sistema.controlador;

import com.sistema.modelo.Justificacion;
import com.sistema.servicio.JustificacionServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Sistema-Inventario-app")
//@CrossOrigin(value = {"http://localhost:4200"})

public class JustificacionControlador {

    private static final Logger logger = LoggerFactory.getLogger(JustificacionControlador.class);

    @Autowired
    private JustificacionServicio justificacionServicio;

    @GetMapping("/justificaciones")
    public List<Justificacion> obtenerJustificaciones() {
        List<Justificacion> justificaciones = this.justificacionServicio.listarTipoJustificacion();
        logger.info("Justificaciones obtenidas");
        return justificaciones;
    }

    @PostMapping("/justificaciones")
    public Justificacion agregarJustificacion(@RequestBody Justificacion justificacion) {
        logger.info("Justificación a agregar: " + justificacion);
        return this.justificacionServicio.guardarTipoJustificacion(justificacion);
    }

    @DeleteMapping("/justificaciones/{idJustificacion}")
    public void eliminarJustificacionPorId(@PathVariable Integer idJustificacion) {
        justificacionServicio.eliminarTipoJustificacionByID(idJustificacion);
        logger.info("Justificación eliminada");
    }

    @GetMapping("/justificaciones/{idJustificacion}")
    public ResponseEntity<Justificacion> obtenerJustificacionPorId(@PathVariable Integer idJustificacion) {
        Justificacion justificacion = justificacionServicio.buscarPorId(idJustificacion);
        if (justificacion != null) {
            return ResponseEntity.ok(justificacion);
        }
        return ResponseEntity.notFound().build();
    }
}
