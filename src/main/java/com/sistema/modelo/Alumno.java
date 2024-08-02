package com.sistema.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "alumnos")
public class Alumno {
    @Id
    private String idAlumno;

    private Integer idCarrera;
    private Integer idGenero;
    private Integer idPeriodo;
    private Integer idSemestre;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String fotoRuta;
    private String grupo;
    private String estatus;
}
