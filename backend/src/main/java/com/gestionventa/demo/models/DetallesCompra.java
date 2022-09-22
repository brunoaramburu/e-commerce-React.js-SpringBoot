package com.gestionventa.demo.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "detalle_compra")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class DetallesCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "IdCompra")
    private Compra idCompra;

    @ManyToOne
    @JoinColumn(name = "IdProducto")
    private Producto idProducto;

    @Column(name = "Cantidad")
    private Integer cantidad;

    @Column(name = "PrecioVenta")
    private Double precioVenta;

}
