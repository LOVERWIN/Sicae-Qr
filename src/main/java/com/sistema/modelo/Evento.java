package com.sistema.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "eventos")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer idEvento;

    private Integer idFacultad;
    private Integer idCarrera;
    private Integer idHorario;
    private Integer idConfig;
    private Integer idLugar;
    private String nombre;
    private String descripcion;
    private Timestamp fechaInicio;
    private Timestamp fechaTermino;
    private String estatus;

}
