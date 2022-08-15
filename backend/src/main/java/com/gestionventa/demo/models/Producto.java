package com.gestionventa.demo.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

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
    @Column(name = "Nombres")
    private String nombres;
    @Column(name = "Precio")
    private Double precio;
    @Column(name = "Stock")
    private Integer stock;
    @Column(name = "Estado")
    private Boolean estado;

}
