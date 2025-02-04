package com.gestor.gatos.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Ingreso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIngreso;

    @Column(nullable = false)
    private Double monto;

    @Column(nullable = false)
    private Timestamp fecha;

    private String descripcion;


    @ManyToOne
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    private Usuario idUsuario;

    @ManyToOne
    @JoinColumn(name = "idCategoria", referencedColumnName = "idCategoria")
    private Categoria idCategoria;

    @ManyToOne
    @JoinColumn(name = "idMetodoPago", referencedColumnName = "idMetodoPago")
    private MetodoPago idMetodoPago;
}
