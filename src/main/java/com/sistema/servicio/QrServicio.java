package com.sistema.servicio;

import com.sistema.modelo.Qr;
import com.sistema.repositorio.IQrRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QrServicio implements IQrServicio {

    @Autowired
    private IQrRepositorio qrRepositorio;

    @Override
    public List<Qr> listarQrs() {
        return qrRepositorio.findAll();
    }

    @Override
    public Qr guardarQr(Qr qr) {
        return qrRepositorio.save(qr);
    }

    @Override
    public void eliminarQrByID(Integer idQr) {
        qrRepositorio.deleteById(idQr);
    }

    @Override
    public Qr buscarPorId(Integer idQr) {
        return qrRepositorio.findById(idQr).orElse(null);
    }
}
