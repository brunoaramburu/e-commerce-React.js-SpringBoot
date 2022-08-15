package com.gestionventa.demo.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;

@Entity
@Table(name = "empleado")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Empleado{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmpleado;
    @Column(name = "Dni")
    private String dni;
    @Column(name = "Nombres")
    private String nombres;
    @Column(name = "Telefono")
    private String telefono;
    @Column(name = "Direccion")
    private String direccion;
    @Column(name = "Estado")
    private Boolean estado;
    @Column(name = "User")
    private String user;


    public Empleado() {
    }

    public Empleado(Integer idEmpleado, String dni, String nombres, String telefono, String direccion, Boolean estado, String user) {
        this.idEmpleado = idEmpleado;
        this.dni = dni;
        this.nombres = nombres;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estado = estado;
        this.user = user;
    }
}
