package com.sistema.servicio;

import com.sistema.modelo.Alumno;
import com.sistema.modelo.Credencial;

import java.util.List;

public interface ICredencialServicio {

    public List<Credencial> listarCredenciales();

    public Credencial guardarCredencial(Credencial credencial);

    public void eliminarCredencialByID(Integer idCredencial);

    public Credencial buscarPorId(Integer idCredencial);

    boolean validarCredenciales(String email, String contrasena);
}
