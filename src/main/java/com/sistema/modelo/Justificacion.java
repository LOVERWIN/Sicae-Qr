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
@Table(name = "justificaciones")
public class Justificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idJustificacion;

    private Integer idAsistenciaFk;
    private Integer idTipoJustificacion;
    private String observacionJustificacion;

}
