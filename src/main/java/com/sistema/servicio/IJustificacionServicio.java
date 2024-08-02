package com.sistema.servicio;

import com.sistema.modelo.Justificacion;
import java.util.List;

public interface IJustificacionServicio {

    public List<Justificacion> listarTipoJustificacion();

    public Justificacion guardarTipoJustificacion(Justificacion justificacion);

    public void eliminarTipoJustificacionByID(Integer idJustificacion);

    public Justificacion buscarPorId(Integer idJustificacion);
}
