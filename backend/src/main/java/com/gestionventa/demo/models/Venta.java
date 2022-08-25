package com.gestionventa.demo.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicReference;

@Entity
@Table(name = "venta")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /*@ManyToOne
    @JoinColumn(name = "IdCliente")
    private Cliente idCliente;

    @ManyToOne
    @JoinColumn(name = "IdEmpleado")
    private Empleado idEmpleado; */

    @Column(name = "NumeroSerie", unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String numeroSerie;

    @Column(name = "FechaVenta")
    private LocalDateTime fechaVenta;

    @Column(name = "Monto")
    private AtomicReference<Double> monto;

    @Column(name = "Estado")
    private Boolean estado;
}
