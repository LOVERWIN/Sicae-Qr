package com.sistema.controlador;

import com.sistema.modelo.Campus;
import com.sistema.servicio.ICampusServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Sistema-Inventario-app")
//@CrossOrigin(value = {"http://localhost:4200"})
public class CampusControlador {

    private static final Logger logger = LoggerFactory.getLogger(CampusControlador.class);

    @Autowired
    private ICampusServicio campusServicio;

    @GetMapping("/campus")
    public List<Campus> obtenerCampus() {
        List<Campus> campusList = this.campusServicio.listarCampus();
        logger.info("Campus obtenidos");
        return campusList;
    }

    @PostMapping("/campus")
    public Campus agregarCampus(@RequestBody Campus campus) {
        logger.info("Campus a agregar: " + campus);
        return this.campusServicio.guardarCampus(campus);
    }

    @DeleteMapping("/campus/{idCampus}")
    public void eliminarCampusPorId(@PathVariable Integer idCampus) {
        campusServicio.eliminarCampusByID(idCampus);
        logger.info("Campus eliminado");
    }

    @GetMapping("/campus/{idCampus}")
    public ResponseEntity<Campus> obtenerCampusPorId(@PathVariable Integer idCampus) {
        Campus campus = campusServicio.buscarPorId(idCampus);
        if (campus != null) {
            return ResponseEntity.ok(campus);
        }
        return ResponseEntity.notFound().build();
    }
}
