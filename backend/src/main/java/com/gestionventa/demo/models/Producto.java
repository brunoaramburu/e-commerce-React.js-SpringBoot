package com.gestionventa.demo.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;

@Entity
@Table(name = "producto")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Nombres", nullable = false, length = 30)
    private String nombres;
    @Column(name = "categoria", nullable = false, length = 30)
    private String categoria;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    @Column(name = "Precio", nullable = false, length = 500)
    @Min(0)
    private Double precio;
    @Column(name = "Stock", nullable = false)
    @Min(0)
    private Integer stock;
    @Column(name = "Estado")
    private Boolean estado;
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaDeCreacion;
    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaDeActualizacion;


}
