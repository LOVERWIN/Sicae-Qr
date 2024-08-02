package com.sistema.controlador;

import com.sistema.modelo.Roles;
import com.sistema.servicio.IRolesServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Sistema-Inventario-app")
//@CrossOrigin(value = {"http://localhost:4200"})
public class RolesControlador {

    private static final Logger logger = LoggerFactory.getLogger(RolesControlador.class);

    @Autowired
    private IRolesServicio rolesServicio;

    @GetMapping("/roles")
    public List<Roles> obtenerRoles() {
        List<Roles> roles = rolesServicio.listarRoles();
        logger.info("Roles obtenidos");
        return roles;
    }

    @PostMapping("/roles")
    public Roles agregarRoles(@RequestBody Roles roles) {
        logger.info("Roles a agregar: " + roles);
        return rolesServicio.guardarRoles(roles);
    }

    @DeleteMapping("/roles/{idRoles}")
    public void eliminarRolesPorId(@PathVariable Integer idRoles) {
        rolesServicio.eliminarRolesByID(idRoles);
        logger.info("Roles eliminados");
    }

    @GetMapping("/roles/{idRoles}")
    public ResponseEntity<Roles> obtenerRolesPorId(@PathVariable Integer idRoles) {
        Roles roles = rolesServicio.buscarPorId(idRoles);
        if (roles != null) {
            return ResponseEntity.ok(roles);
        }
        return ResponseEntity.notFound().build();
    }
}
