package com.sistema.controlador;

import com.sistema.modelo.Facultad;
import com.sistema.servicio.IFacultadServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Sistema-Inventario-app")
//@CrossOrigin(value = {"http://localhost:4200"})
public class FacultadControlador {

    private static final Logger logger = LoggerFactory.getLogger(FacultadControlador.class);

    @Autowired
    private IFacultadServicio facultadServicio;

    @GetMapping("/facultades")
    public List<Facultad> obtenerFacultades() {
        List<Facultad> facultades = facultadServicio.listarFacultades();
        logger.info("Facultades obtenidas");
        return facultades;
    }

    @PostMapping("/facultades")
    public Facultad agregarFacultad(@RequestBody Facultad facultad) {
        logger.info("Facultad a agregar: " + facultad);
        return facultadServicio.guardarFacultad(facultad);
    }

    @DeleteMapping("/facultades/{idFacultad}")
    public void eliminarFacultadPorId(@PathVariable Integer idFacultad) {
        facultadServicio.eliminarFacultadByID(idFacultad);
        logger.info("Facultad eliminada");
    }

    @GetMapping("/facultades/{idFacultad}")
    public ResponseEntity<Facultad> obtenerFacultadPorId(@PathVariable Integer idFacultad) {
        Facultad facultad = facultadServicio.buscarPorId(idFacultad);
        if (facultad != null) {
            return ResponseEntity.ok(facultad);
        }
        return ResponseEntity.notFound().build();
    }
}
