package com.sistema.servicio;

import com.sistema.modelo.ConfigChecador;
import com.sistema.repositorio.IConfigChecadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ConfigChecadorServicio implements IConfigChecadorServicio{
    @Autowired
    private IConfigChecadorRepositorio iConfigChecadorRepositorio;

    @Override
    public List<ConfigChecador> listarConfigChecador() {
        return this.iConfigChecadorRepositorio.findAll();
    }

    @Override
    public ConfigChecador guardarConfigChecador(ConfigChecador configChecador) {
        return this.iConfigChecadorRepositorio.save(configChecador);
    }

    @Override
    public void eliminarConfigChecadorByID(Integer idConfigChecador) {
        this.iConfigChecadorRepositorio.deleteById(idConfigChecador);
    }

    @Override
    public ConfigChecador buscarPorId(Integer idConfigChecador) {
        return this.iConfigChecadorRepositorio.findById(idConfigChecador).orElse(null);
    }
}
