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
public class Categoria {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idCategoria;


    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String tipo; // Valores: "Gasto" o "Ingreso"

    private String descripcion;

    @JsonIgnore
    @OneToMany(mappedBy = "idCategoria", cascade = CascadeType.ALL)
    private List<Gasto> gastos;

    @JsonIgnore
    @OneToMany(mappedBy = "idCategoria", cascade = CascadeType.ALL)
    private List<Ingreso> ingresos;
}

