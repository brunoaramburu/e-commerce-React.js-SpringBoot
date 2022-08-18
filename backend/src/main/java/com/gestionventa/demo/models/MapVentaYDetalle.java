package com.gestionventa.demo.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class MapVentaYDetalle {

    private Venta venta;
    private List<DetallesVenta> detallesVentas;

    public MapVentaYDetalle(Venta venta, List<DetallesVenta> detallesVentas) {
        this.venta = venta;
        this.detallesVentas = detallesVentas;
    }
}
