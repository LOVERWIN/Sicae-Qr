package com.sistema.controlador;

import com.sistema.modelo.Evento;
import com.sistema.servicio.EventoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Sistema-Inventario-app")
//@CrossOrigin(value = {"http://localhost:4200"})
public class EventoControlador {

    private static final Logger logger = LoggerFactory.getLogger(EventoControlador.class);

    @Autowired
    private EventoServicio eventoServicio;

    @GetMapping(value = "/eventos")
    public List<Evento> obtenerEventos() {
        List<Evento> eventos = this.eventoServicio.listarEvento();

        logger.info("Eventos obtenidos: "+  eventos);
        return eventos;
    }

    @GetMapping("/prueba")
    @ResponseBody
    public String prueba() {
        return "áéíóú";
    }


    @PostMapping("/eventos")
    public Evento agregarEvento(@RequestBody Evento evento) {
        logger.info("Evento a agregar: " + evento);
        return this.eventoServicio.guardarEvento(evento);
    }

    @DeleteMapping("/eventos/{idEvento}")
    public void eliminarEventoPorId(@PathVariable Integer idEvento) {
        eventoServicio.eliminarEventoByID(idEvento);
        logger.info("Evento eliminado");
    }

    @GetMapping("/eventos/{idEvento}")
    public ResponseEntity<Evento> obtenerEventoPorId(@PathVariable Integer idEvento) {
        Evento evento = eventoServicio.buscarPorId(idEvento);
        if (evento != null) {
            return ResponseEntity.ok(evento);
        }
        return ResponseEntity.notFound().build();
    }
}
