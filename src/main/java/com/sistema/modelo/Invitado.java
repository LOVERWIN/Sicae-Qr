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
@Table(name = "invitados")
public class Invitado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInvitado;

    private Integer idEvento;
    private Integer idTipoInvitado;
    private Integer idGenero;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String institucionProcedencia;

}
