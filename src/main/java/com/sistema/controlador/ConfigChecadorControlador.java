package com.sistema.controlador;

import com.sistema.modelo.ConfigChecador;
import com.sistema.servicio.ConfigChecadorServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Sistema-Inventario-app")
//@CrossOrigin(value = {"http://localhost:4200"})
public class ConfigChecadorControlador {

    private static final Logger logger = LoggerFactory.getLogger(ConfigChecadorControlador.class);

    @Autowired
    private ConfigChecadorServicio configChecadorServicio;

    @GetMapping("/config-checadores")
    public List<ConfigChecador> obtenerConfigChecadores() {
        List<ConfigChecador> configChecadores = this.configChecadorServicio.listarConfigChecador();
        logger.info("ConfigChecadores obtenidos");
        return configChecadores;
    }

    @PostMapping("/config-checadores")
    public ConfigChecador agregarConfigChecador(@RequestBody ConfigChecador configChecador) {
        logger.info("ConfigChecador a agregar: " + configChecador);
        return this.configChecadorServicio.guardarConfigChecador(configChecador);
    }

    @DeleteMapping("/config-checadores/{idConfigChecador}")
    public void eliminarConfigChecadorPorId(@PathVariable Integer idConfigChecador) {
        configChecadorServicio.eliminarConfigChecadorByID(idConfigChecador);
        logger.info("ConfigChecador eliminado");
    }

    @GetMapping("/config-checadores/{idConfigChecador}")
    public ResponseEntity<ConfigChecador> obtenerConfigChecadorPorId(@PathVariable Integer idConfigChecador) {
        ConfigChecador configChecador = configChecadorServicio.buscarPorId(idConfigChecador);
        if (configChecador != null) {
            return ResponseEntity.ok(configChecador);
        }
        return ResponseEntity.notFound().build();
    }
}
