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
@Table(name = "tipo_justificaciones")
public class TipoJustificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoJustificacion;

    private String descripcion;
}
