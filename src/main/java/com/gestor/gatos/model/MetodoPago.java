package com.gestor.gatos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class MetodoPago {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idMetodoPago;

    @Column(nullable = false)
    private String nombre; // Ejemplo: "Tarjeta de Crédito", "Efectivo"

    @JsonIgnore
    @OneToMany(mappedBy = "idMetodoPago", cascade = CascadeType.ALL)
    private List<Gasto> gastos;

    @JsonIgnore
    @OneToMany(mappedBy = "idMetodoPago", cascade = CascadeType.ALL)
    private List<Ingreso> ingresos;
}

