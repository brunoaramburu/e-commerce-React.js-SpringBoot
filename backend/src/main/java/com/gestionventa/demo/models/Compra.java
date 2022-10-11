package com.gestionventa.demo.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicReference;

@Entity
@Table(name = "compra")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "numeroSerie", unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String numeroSerie;
    @Column(name = "fechaVenta")
    private LocalDateTime fechaVenta;
    @Column(name = "monto")
    @Min(0)
    private Double monto;
    @Column(name = "estado")
    private Boolean estado;
    @ManyToOne
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaDeCreacion;
    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaDeActualizacion;

}
