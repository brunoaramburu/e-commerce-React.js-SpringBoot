package com.gestionventa.demo.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;
import java.util.ArrayList;

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
    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;
    @Column(name = "categoria", length = 30)
    private String categoria;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "Precio", nullable = false, length = 500)
    @Min(0)
    private Double precio;
    @Column(name = "Stock", nullable = false)
    @Min(0)
    private Integer stock;
    @Column(name = "Estado")
    private Boolean estado;
    @ManyToOne
    @JoinColumn(name = "venedor")
    private Usuario vendedor;
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaDeCreacion;
    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaDeActualizacion;
    @Column(name = "links_imagenes")
    private ArrayList<String> linkImagenes;

}
