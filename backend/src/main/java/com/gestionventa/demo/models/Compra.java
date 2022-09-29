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
    @Column(name = "numero_serie")
    private String numeroSerie;
    @Column(name = "fecha_compra")
    private LocalDateTime fechaCompra;
    @Column(name = "total")
    @Min(0)
    private Double total;

}
