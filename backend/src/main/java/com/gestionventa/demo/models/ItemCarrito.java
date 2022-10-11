package com.gestionventa.demo.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    @ManyToOne
    @Column(name = "Cantidad")
    private Integer cantidad;
    @Column(name = "PrecioVenta")
    private Double precioVenta;
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaDeCreacion;
    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaDeActualizacion;
}
