package com.sistema.servicio;

import com.sistema.modelo.Alumno;
import com.sistema.modelo.ConfigChecador;

import java.util.List;

public interface IConfigChecadorServicio {
    public List<ConfigChecador> listarConfigChecador();

    public ConfigChecador guardarConfigChecador(ConfigChecador configChecador);

    public void eliminarConfigChecadorByID(Integer idConfigChecador);

    public ConfigChecador buscarPorId(Integer idConfigChecador);
}
