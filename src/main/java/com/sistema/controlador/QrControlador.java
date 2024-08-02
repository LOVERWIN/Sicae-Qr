package com.sistema.controlador;

import com.sistema.modelo.Qr;
import com.sistema.servicio.IQrServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Sistema-Inventario-app")
//@CrossOrigin(value = {"http://localhost:4200"})
public class QrControlador {

    private static final Logger logger = LoggerFactory.getLogger(QrControlador.class);

    @Autowired
    private IQrServicio qrServicio;

    @GetMapping("/qrs")
    public List<Qr> obtenerQrs() {
        List<Qr> qrs = qrServicio.listarQrs();
        logger.info("Qrs obtenidos");
        return qrs;
    }

    @PostMapping("/qrs")
    public Qr agregarQr(@RequestBody Qr qr) {
        logger.info("Qr a agregar: " + qr);
        return qrServicio.guardarQr(qr);
    }

    @DeleteMapping("/qrs/{idQr}")
    public void eliminarQrPorId(@PathVariable Integer idQr) {
        qrServicio.eliminarQrByID(idQr);
        logger.info("Qr eliminado");
    }

    @GetMapping("/qrs/{idQr}")
    public ResponseEntity<Qr> obtenerQrPorId(@PathVariable Integer idQr) {
        Qr qr = qrServicio.buscarPorId(idQr);
        if (qr != null) {
            return ResponseEntity.ok(qr);
        }
        return ResponseEntity.notFound().build();
    }
}
