package com.gestionventa.demo.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "nombre_de_usuario", unique = true)
    private String nombreDeUsuario;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "DNI")
    private String DNI;
    @Column(name = "estado")
    private Boolean estado;
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaDeCreacion;
    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaDeActualizacion;
}
