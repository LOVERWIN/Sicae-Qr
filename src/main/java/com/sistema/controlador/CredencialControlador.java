package com.sistema.controlador;

import com.sistema.excepcion.RecursoNoEncontradoExcepcion;
import com.sistema.modelo.Credencial;
import com.sistema.servicio.CredencialServicio;
import com.sistema.servicio.ICredencialServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("Sistema-Inventario-app")
//@CrossOrigin(value = {"http://localhost:4200"})
public class CredencialControlador {

    private static final Logger logger = LoggerFactory.getLogger(CredencialControlador.class);

    @Autowired
    private ICredencialServicio credencialServicio;

    @GetMapping("/credenciales")
    public List<Credencial> obtenerCredenciales() {
        List<Credencial> credenciales = this.credencialServicio.listarCredenciales();
        logger.info("Credenciales obtenidos");
        return credenciales;
    }

    @PostMapping("/credenciales")
    public Credencial agregarCredencial(@RequestBody Credencial credencial) {
        logger.info("Credencial a agregar: " + credencial);
        return this.credencialServicio.guardarCredencial(credencial);
    }

    @DeleteMapping("/credenciales/{idCredencial}")
    public void eliminarCredencialPorId(@PathVariable Integer idCredencial) {
        credencialServicio.eliminarCredencialByID(idCredencial);
        logger.info("Credencial eliminado");
    }

    @GetMapping("/credenciales/{idCredencial}")
    public ResponseEntity<Credencial> obtenerCredencialPorId(@PathVariable Integer idCredencial) {
        Credencial credencial = credencialServicio.buscarPorId(idCredencial);
        if (credencial != null) {
            return ResponseEntity.ok(credencial);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Credencial credencial) {
        String email = credencial.getEmail();
        String contrasena = credencial.getContrasena();

        if (credencialServicio.validarCredenciales(email, contrasena)) {
            Map<String, String> response = new HashMap<>();
            response.put("mensaje", "¡Inicio de sesión exitoso!");
            return ResponseEntity.ok(response);
        } else {
            throw new RecursoNoEncontradoExcepcion("Credenciales incorrectas");
        }
    }
}
