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
@Table(name = "lugares_eventos")
public class LugarEvento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLugar;

    private Integer idFacultad;
    private String nombre;
    private Integer capacidad;
}
