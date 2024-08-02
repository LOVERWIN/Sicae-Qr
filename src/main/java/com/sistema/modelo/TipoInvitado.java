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
@Table(name = "tipo_invitados")
public class TipoInvitado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoInvitado;

    private String descripcion;

}
