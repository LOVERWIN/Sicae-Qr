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
@Table(name = "credenciales")
public class Credencial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCredencial;

    private String email;
    private String contrasena;


}
