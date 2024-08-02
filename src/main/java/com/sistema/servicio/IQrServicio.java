package com.sistema.servicio;

import com.sistema.modelo.Qr;

import java.util.List;

public interface IQrServicio {

    List<Qr> listarQrs();

    Qr guardarQr(Qr qr);

    void eliminarQrByID(Integer idQr);

    Qr buscarPorId(Integer idQr);
}
