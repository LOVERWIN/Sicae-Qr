package com.sistema.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Time;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "config_checador")
public class ConfigChecador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idConfig;

    private Integer hora;
    private Time toleranciaAsistencia;
    private Time toleranciaRetardo;
    private Time toleranciaFalta;
    private Time antesEntrada;
    private Time despuesSalida;


}
