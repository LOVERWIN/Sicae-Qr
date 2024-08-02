package com.sistema.servicio;

import com.sistema.modelo.LugarEvento;


import java.util.List;

public interface ILugarEventoServicio {

    public List<LugarEvento> listarLugarEvento();

    public LugarEvento guardarLugarEvento(LugarEvento idLugar);

    public void eliminarLugarEventoByID(Integer idLugar);

    public LugarEvento buscarPorId(Integer idLugar);
}
