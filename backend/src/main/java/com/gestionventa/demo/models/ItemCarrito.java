package com.gestionventa.demo.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;

@Entity
@Table(name = "item_carrito")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ItemCarrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_compra")
    private Compra idCompra;
    @JoinColumn(name = "comprador")
    @ManyToOne
    private Usuario idComprador;
    @ManyToMany
    @JoinColumn(name = "id_producto")
    private Producto idProducto;
    @JoinColumn(name = "vendedor")
    @Min(1)
    private Integer cantidad;
    @Column(name = "precio_venta")
    @Min(0)
    private Double precioVenta;

}
