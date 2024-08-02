package com.sistema.controlador;

import com.sistema.modelo.Carrera;
import com.sistema.servicio.ICarreraServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Sistema-Inventario-app")
//@CrossOrigin(value = {"http://localhost:4200"})
public class CarreraControlador {

    private static final Logger logger = LoggerFactory.getLogger(CarreraControlador.class);

    @Autowired
    private ICarreraServicio carreraServicio;

    @GetMapping("/carreras")
    public List<Carrera> obtenerCarreras() {
        List<Carrera> carreras = carreraServicio.listarCarreras();
        logger.info("Carreras obtenidas");
        return carreras;
    }

    @PostMapping("/carreras")
    public Carrera agregarCarrera(@RequestBody Carrera carrera) {
        logger.info("Carrera a agregar: " + carrera);
        return carreraServicio.guardarCarrera(carrera);
    }

    @DeleteMapping("/carreras/{idCarrera}")
    public void eliminarCarreraPorId(@PathVariable Integer idCarrera) {
        carreraServicio.eliminarCarreraByID(idCarrera);
        logger.info("Carrera eliminada");
    }

    @GetMapping("/carreras/{idCarrera}")
    public ResponseEntity<Carrera> obtenerCarreraPorId(@PathVariable Integer idCarrera) {
        Carrera carrera = carreraServicio.buscarPorId(idCarrera);
        if (carrera != null) {
            return ResponseEntity.ok(carrera);
        }
        return ResponseEntity.notFound().build();
    }
}
