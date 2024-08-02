package com.sistema.servicio;

import com.sistema.modelo.Credencial;
import com.sistema.repositorio.ICredencialRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CredencialServicio implements ICredencialServicio{
    @Autowired
    private ICredencialRepositorio iCredencialRepositorio;
    @Override
    public List<Credencial> listarCredenciales() {
        return this.iCredencialRepositorio.findAll();
    }

    @Override
    public Credencial guardarCredencial(Credencial credencial) {
        return this.iCredencialRepositorio.save(credencial);
    }

    @Override
    public void eliminarCredencialByID(Integer idCredencial) {
        this.iCredencialRepositorio.deleteById(idCredencial);
    }

    @Override
    public Credencial buscarPorId(Integer idCredencial) {
        return this.iCredencialRepositorio.findById(idCredencial).orElse(null);
    }

    @Override
    public boolean validarCredenciales(String email, String contrasena) {
        Credencial credencial = iCredencialRepositorio.findByEmail(email);
        return credencial != null && credencial.getContrasena().equals(contrasena);
    }
}
