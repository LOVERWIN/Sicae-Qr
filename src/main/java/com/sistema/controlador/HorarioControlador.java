package com.sistema.controlador;

import com.sistema.modelo.Horario;
import com.sistema.servicio.IHorarioServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Sistema-Inventario-app")
//@CrossOrigin(value = {"http://localhost:4200"})
public class HorarioControlador {

    private static final Logger logger = LoggerFactory.getLogger(HorarioControlador.class);

    @Autowired
    private IHorarioServicio horarioServicio;

    @GetMapping("/horarios")
    public List<Horario> obtenerHorarios() {
        List<Horario> horarios = horarioServicio.listarHorarios();
        logger.info("Horarios obtenidos");
        return horarios;
    }

    @PostMapping("/horarios")
    public Horario agregarHorario(@RequestBody Horario horario) {
        logger.info("Horario a agregar: " + horario);
        return horarioServicio.guardarHorario(horario);
    }

    @DeleteMapping("/horarios/{idHorario}")
    public void eliminarHorarioPorId(@PathVariable Integer idHorario) {
        horarioServicio.eliminarHorarioByID(idHorario);
        logger.info("Horario eliminado");
    }

    @GetMapping("/horarios/{idHorario}")
    public ResponseEntity<Horario> obtenerHorarioPorId(@PathVariable Integer idHorario) {
        Horario horario = horarioServicio.buscarPorId(idHorario);
        if (horario != null) {
            return ResponseEntity.ok(horario);
        }
        return ResponseEntity.notFound().build();
    }
}
