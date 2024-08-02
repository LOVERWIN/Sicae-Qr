package com.sistema.controlador;

import com.sistema.modelo.Sesion;
import com.sistema.servicio.ISesionServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Sistema-Inventario-app")
//@CrossOrigin(value = {"http://localhost:4200"})
public class SesionControlador {

    private static final Logger logger = LoggerFactory.getLogger(SesionControlador.class);

    @Autowired
    private ISesionServicio sesionServicio;

    @GetMapping("/sesiones")
    public List<Sesion> obtenerSesiones() {
        List<Sesion> sesiones = sesionServicio.listarSesiones();
        logger.info("Sesiones obtenidas");
        return sesiones;
    }

    @PostMapping("/sesiones")
    public Sesion agregarSesion(@RequestBody Sesion sesion) {
        logger.info("Sesion a agregar: " + sesion);
        return sesionServicio.guardarSesion(sesion);
    }

    @DeleteMapping("/sesiones/{idSesion}")
    public void eliminarSesionPorId(@PathVariable Integer idSesion) {
        sesionServicio.eliminarSesionByID(idSesion);
        logger.info("Sesion eliminada");
    }

    @GetMapping("/sesiones/{idSesion}")
    public ResponseEntity<Sesion> obtenerSesionPorId(@PathVariable Integer idSesion) {
        Sesion sesion = sesionServicio.buscarPorId(idSesion);
        if (sesion != null) {
            return ResponseEntity.ok(sesion);
        }
        return ResponseEntity.notFound().build();
    }
}
