package com.sistema.controlador;

import com.sistema.modelo.Asistencia;
import com.sistema.servicio.AsistenciaServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Sistema-Inventario-app")
//@CrossOrigin(value = {"http://localhost:4200"})
public class AsistenciaControlador {

    private static final Logger logger = LoggerFactory.getLogger(AsistenciaControlador.class);

    @Autowired
    private AsistenciaServicio asistenciaServicio;

    @GetMapping("/asistencias")
    public ResponseEntity<List<Asistencia>> obtenerAsistencias() {
        List<Asistencia> asistencias = this.asistenciaServicio.listarAsistencias();
        logger.info("Asistencias obtenidas");
        return ResponseEntity.ok(asistencias);
    }

    @PostMapping("/asistencias")
    public ResponseEntity<Asistencia> agregarAsistencia(@RequestBody Asistencia asistencia) {
        logger.info("Asistencia a agregar: " + asistencia);
        Asistencia nuevaAsistencia = this.asistenciaServicio.guardarAsistencia(asistencia);
        return ResponseEntity.ok(nuevaAsistencia);
    }

    @DeleteMapping("/asistencias/{idAsistencia}")
    public ResponseEntity<Void> eliminarAsistenciaPorId(@PathVariable Integer idAsistencia) {
        asistenciaServicio.eliminarAsistenciaByID(idAsistencia);
        logger.info("Asistencia eliminada");
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/asistencias/{idAsistencia}")
    public ResponseEntity<Asistencia> obtenerAsistenciaPorId(@PathVariable Integer idAsistencia) {
        Asistencia asistencia = asistenciaServicio.buscarPorId(idAsistencia);
        if (asistencia != null) {
            return ResponseEntity.ok(asistencia);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/asistencias/alumno/{idAlumno}/tipo/{tipoRegistro}/evento/{idEvento}")
    public ResponseEntity<Asistencia> obtenerAsistenciasPorIdAlumnoTipoRegistroYIdEvento(
            @PathVariable String idAlumno,
            @PathVariable String tipoRegistro,
            @PathVariable Integer idEvento) {
        Asistencia asistencias = asistenciaServicio.obtenerAsistenciasPorIdAlumnoTipoRegistroYIdEvento(idAlumno, tipoRegistro, idEvento);
        if (asistencias != null) {
            return ResponseEntity.ok(asistencias);
        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/asistencias/evento/{idEvento}/tipo/{tipoRegistro}/total")
    public ResponseEntity<Integer> obtenerTotalAsistenciasPorEventoYTipoRegistro(
            @PathVariable Integer idEvento,
            @PathVariable String tipoRegistro) {
        int totalAsistencias = asistenciaServicio.contarAsistenciasPorEventoYTipoRegistro(idEvento, tipoRegistro);
        return ResponseEntity.ok(totalAsistencias);
    }

}
