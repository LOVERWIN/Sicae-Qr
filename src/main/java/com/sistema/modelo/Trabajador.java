package com.sistema.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "Trabajadores")
public class Trabajador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTrabajador;

    private Integer idRol;
    private Integer idFacultad;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private Timestamp fechaIngreso;
    private char estatus;

}
