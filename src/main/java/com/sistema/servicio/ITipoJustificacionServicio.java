package com.sistema.servicio;

import com.sistema.modelo.Alumno;
import com.sistema.modelo.TipoJustificacion;

import java.util.List;

public interface ITipoJustificacionServicio {

    public List<TipoJustificacion> listarTipoJustificacion();

    public TipoJustificacion guardarTipoJustificacion(TipoJustificacion tipoJustificacion);

    public void eliminarTipoJustificacionByID(Integer idTipoJustificacion);

    public TipoJustificacion buscarPorId(Integer idTipoJustificacion);

}
