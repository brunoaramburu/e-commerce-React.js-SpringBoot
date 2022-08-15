package com.gestionventa.demo.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "venta")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Venta {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVenta;

    /*@ManyToOne
    @JoinColumn(name = "IdCliente")
    private Cliente idCliente;

    @ManyToOne
    @JoinColumn(name = "IdEmpleado")
    private Empleado idEmpleado; */

    @Column(name = "NumeroSerie")
    private String numeroSerie;

    @Column(name = "FechaVenta")
    private Date fechaVenta;

    @Column(name = "Monto")
    private Double monto;

    @Column(name = "Estado")
    private Boolean estado;
}
