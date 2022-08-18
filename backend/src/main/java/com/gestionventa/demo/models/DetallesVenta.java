package com.gestionventa.demo.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "detalle_ventas")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class DetallesVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "IdVentas")
    private Venta idVentas;

    @ManyToOne
    @JoinColumn(name = "IdProducto")
    private Producto idProducto;

    @Column(name = "Cantidad")
    private Integer cantidad;

    @Column(name = "PrecioVenta")
    private Double precioVenta;

}
