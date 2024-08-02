package com.sistema.controlador;

import com.sistema.modelo.Invitado;
import com.sistema.servicio.InvitadoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Sistema-Inventario-app")
//@CrossOrigin(value = {"http://localhost:4200"})
public class InvitadoControlador {

    private static final Logger logger = LoggerFactory.getLogger(InvitadoControlador.class);

    @Autowired
    private InvitadoServicio invitadoServicio;

    @GetMapping("/invitados")
    public List<Invitado> obtenerInvitados() {
        List<Invitado> invitados = this.invitadoServicio.listarInvitados();
        logger.info("Invitados obtenidos");
        return invitados;
    }

    @PostMapping("/invitados")
    public Invitado agregarInvitado(@RequestBody Invitado invitado) {
        logger.info("Invitado a agregar: " + invitado);
        return this.invitadoServicio.guardarInvitados(invitado);
    }

    @DeleteMapping("/invitados/{idInvitado}")
    public void eliminarInvitadoPorId(@PathVariable Integer idInvitado) {
        invitadoServicio.eliminarInvitadoByID(idInvitado);
        logger.info("Invitado eliminado");
    }

    @GetMapping("/invitados/{idInvitado}")
    public ResponseEntity<Invitado> obtenerInvitadoPorId(@PathVariable Integer idInvitado) {
        Invitado invitado = invitadoServicio.buscarPorId(idInvitado);
        if (invitado != null) {
            return ResponseEntity.ok(invitado);
        }
        return ResponseEntity.notFound().build();
    }
}
