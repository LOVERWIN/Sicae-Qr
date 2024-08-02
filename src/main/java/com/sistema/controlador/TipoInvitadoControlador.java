package com.sistema.controlador;

import com.sistema.modelo.TipoInvitado;
import com.sistema.servicio.TipoInvitadoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Sistema-Inventario-app")
//@CrossOrigin(value = {"http://localhost:4200"})
public class TipoInvitadoControlador {

    private static final Logger logger = LoggerFactory.getLogger(TipoInvitadoControlador.class);

    @Autowired
    private TipoInvitadoServicio tipoInvitadoServicio;

    @GetMapping("/tipos-invitado")
    public List<TipoInvitado> obtenerTiposInvitado() {
        List<TipoInvitado> tiposInvitado = this.tipoInvitadoServicio.listarTipoInvitados();
        logger.info("Tipos de invitado obtenidos");
        return tiposInvitado;
    }

    @PostMapping("/tipos-invitado")
    public TipoInvitado agregarTipoInvitado(@RequestBody TipoInvitado tipoInvitado) {
        logger.info("Tipo de invitado a agregar: " + tipoInvitado);
        return this.tipoInvitadoServicio.guardarTipoInvitado(tipoInvitado);
    }

    @DeleteMapping("/tipos-invitado/{idTipoInvitado}")
    public void eliminarTipoInvitadoPorId(@PathVariable Integer idTipoInvitado) {
        tipoInvitadoServicio.eliminarTipoInvitadoByID(idTipoInvitado);
        logger.info("Tipo de invitado eliminado");
    }

    @GetMapping("/tipos-invitado/{idTipoInvitado}")
    public ResponseEntity<TipoInvitado> obtenerTipoInvitadoPorId(@PathVariable Integer idTipoInvitado) {
        TipoInvitado tipoInvitado = tipoInvitadoServicio.buscarPorId(idTipoInvitado);
        if (tipoInvitado != null) {
            return ResponseEntity.ok(tipoInvitado);
        }
        return ResponseEntity.notFound().build();
    }
}
