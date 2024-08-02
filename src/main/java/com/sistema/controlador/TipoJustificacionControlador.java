package com.sistema.controlador;

import com.sistema.modelo.TipoJustificacion;
import com.sistema.servicio.TipoJustificacionServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Sistema-Inventario-app")
//@CrossOrigin(value = {"http://localhost:4200"})
public class TipoJustificacionControlador {

    private static final Logger logger = LoggerFactory.getLogger(TipoJustificacionControlador.class);

    @Autowired
    private TipoJustificacionServicio tipoJustificacionServicio;

    @GetMapping("/tipos-justificacion")
    public List<TipoJustificacion> obtenerTiposJustificacion() {
        List<TipoJustificacion> tiposJustificacion = this.tipoJustificacionServicio.listarTipoJustificacion();
        logger.info("Tipos de justificación obtenidos");
        return tiposJustificacion;
    }

    @PostMapping("/tipos-justificacion")
    public TipoJustificacion agregarTipoJustificacion(@RequestBody TipoJustificacion tipoJustificacion) {
        logger.info("Tipo de justificación a agregar: " + tipoJustificacion);
        return this.tipoJustificacionServicio.guardarTipoJustificacion(tipoJustificacion);
    }

    @DeleteMapping("/tipos-justificacion/{idTipoJustificacion}")
    public void eliminarTipoJustificacionPorId(@PathVariable Integer idTipoJustificacion) {
        tipoJustificacionServicio.eliminarTipoJustificacionByID(idTipoJustificacion);
        logger.info("Tipo de justificación eliminado");
    }

    @GetMapping("/tipos-justificacion/{idTipoJustificacion}")
    public ResponseEntity<TipoJustificacion> obtenerTipoJustificacionPorId(@PathVariable Integer idTipoJustificacion) {
        TipoJustificacion tipoJustificacion = tipoJustificacionServicio.buscarPorId(idTipoJustificacion);
        if (tipoJustificacion != null) {
            return ResponseEntity.ok(tipoJustificacion);
        }
        return ResponseEntity.notFound().build();
    }
}
