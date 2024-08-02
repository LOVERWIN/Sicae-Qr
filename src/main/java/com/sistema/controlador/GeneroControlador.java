package com.sistema.controlador;

import com.sistema.modelo.Genero;
import com.sistema.servicio.IGeneroServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Sistema-Inventario-app")
//@CrossOrigin(value = {"http://localhost:4200"})
public class GeneroControlador {

    private static final Logger logger = LoggerFactory.getLogger(GeneroControlador.class);

    @Autowired
    private IGeneroServicio generoServicio;

    @GetMapping("/generos")
    public List<Genero> obtenerGeneros() {
        List<Genero> generos = generoServicio.listarGeneros();
        logger.info("Géneros obtenidos");
        return generos;
    }

    @PostMapping("/generos")
    public Genero agregarGenero(@RequestBody Genero genero) {
        logger.info("Género a agregar: " + genero);
        return generoServicio.guardarGenero(genero);
    }

    @DeleteMapping("/generos/{idGenero}")
    public void eliminarGeneroPorId(@PathVariable Integer idGenero) {
        generoServicio.eliminarGeneroByID(idGenero);
        logger.info("Género eliminado");
    }

    @GetMapping("/generos/{idGenero}")
    public ResponseEntity<Genero> obtenerGeneroPorId(@PathVariable Integer idGenero) {
        Genero genero = generoServicio.buscarPorId(idGenero);
        if (genero != null) {
            return ResponseEntity.ok(genero);
        }
        return ResponseEntity.notFound().build();
    }
}
