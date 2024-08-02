package com.sistema.controlador;

import com.sistema.modelo.Alumno;
import com.sistema.servicio.AlumnoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("Sistema-Inventario-app")
//@CrossOrigin(value = {"http://localhost:4200"})
public class AlumnoControlador {

    private static final Logger logger = LoggerFactory.getLogger(AlumnoControlador.class);

    @Autowired
    private AlumnoServicio alumnoServicio;


    @GetMapping("/alumnos")
    public List<Alumno> obtenerAlumnos() {
        List<Alumno> alumnos = this.alumnoServicio.listarAlumnos();
        logger.info("Alumnos obtenidos");
        return alumnos;
    }

    @PostMapping("/alumnos")
    public Alumno agregarAlumno(@RequestBody Alumno alumno) {
        logger.info("Alumno a agregar: " + alumno);
        return this.alumnoServicio.guardarAlumno(alumno);
    }

    @DeleteMapping("/alumnos/{idAlumno}")
    public void eliminarAlumnoPorId(@PathVariable String idAlumno) {
        alumnoServicio.eliminarAlumnoByID(idAlumno);
        logger.info("Alumno eliminado");
    }

    @GetMapping("/alumnos/{idAlumno}")
    public ResponseEntity<Alumno> obtenerAlumnoPorId(@PathVariable String idAlumno) {
        Alumno alumno = alumnoServicio.buscarPorId(idAlumno);
        if (alumno != null) {
            return ResponseEntity.ok(alumno);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/alumnos/asistencias/evento/{idEvento}/tipo/{tipoRegistro}")
    public ResponseEntity<List<Alumno>> obtenerAlumnosQueAsistieron(@PathVariable Integer idEvento, @PathVariable String tipoRegistro) {
        List<Alumno> alumnos = alumnoServicio.obtenerAlumnosQueAsistieron(idEvento, tipoRegistro);
        if (!alumnos.isEmpty()) {
            return ResponseEntity.ok(alumnos);
        }
        return ResponseEntity.notFound().build();
    }
}
