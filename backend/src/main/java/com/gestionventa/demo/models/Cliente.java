package com.gestionventa.demo.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
@Getter @Setter
@ToString @EqualsAndHashCode
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    @Column(name = "Dni")
    private String dni;
    @Column(name = "Nombres")
    private String nombres;
    @Column(name = "Direccion")
    private String direccion;
    @Column(name = "Estado")
    private Boolean estado;
}
