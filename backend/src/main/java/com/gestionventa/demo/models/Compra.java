package com.gestionventa.demo.models;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;

@Entity
@Table(name = "compra")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "fecha_venta")
    private LocalDateTime fechaVenta;

    @Column(name = "monto")
    @Min(0)
    private Double monto;

    @Column(name = "estado")
    private Boolean estado;


}
