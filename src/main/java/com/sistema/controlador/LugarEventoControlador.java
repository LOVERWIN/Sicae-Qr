package com.sistema.controlador;

import com.sistema.modelo.LugarEvento;
import com.sistema.servicio.LugarEventoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Sistema-Inventario-app")
//@CrossOrigin(value = {"http://localhost:4200"})
public class LugarEventoControlador {

    private static final Logger logger = LoggerFactory.getLogger(LugarEventoControlador.class);

    @Autowired
    private LugarEventoServicio lugarEventoServicio;

    @GetMapping("/lugares-evento")
    public List<LugarEvento> obtenerLugaresEvento() {
        List<LugarEvento> lugaresEvento = this.lugarEventoServicio.listarLugarEvento();
        logger.info("Lugares de evento obtenidos");
        return lugaresEvento;
    }

    @PostMapping("/lugares-evento")
    public LugarEvento agregarLugarEvento(@RequestBody LugarEvento lugarEvento) {
        logger.info("Lugar de evento a agregar: " + lugarEvento);
        return this.lugarEventoServicio.guardarLugarEvento(lugarEvento);
    }

    @DeleteMapping("/lugares-evento/{idLugarEvento}")
    public void eliminarLugarEventoPorId(@PathVariable Integer idLugarEvento) {
        lugarEventoServicio.eliminarLugarEventoByID(idLugarEvento);
        logger.info("Lugar de evento eliminado");
    }

    @GetMapping("/lugares-evento/{idLugarEvento}")
    public ResponseEntity<LugarEvento> obtenerLugarEventoPorId(@PathVariable Integer idLugarEvento) {
        LugarEvento lugarEvento = lugarEventoServicio.buscarPorId(idLugarEvento);
        if (lugarEvento != null) {
            return ResponseEntity.ok(lugarEvento);
        }
        return ResponseEntity.notFound().build();
    }
}
