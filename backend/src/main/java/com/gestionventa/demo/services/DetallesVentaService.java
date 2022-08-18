package com.gestionventa.demo.services;

import com.gestionventa.demo.models.DetallesVenta;
import com.gestionventa.demo.models.Venta;

import java.util.List;

public interface DetallesVentaService {

    List<DetallesVenta> detallesVentas();

    List<DetallesVenta> findByIdVentas(Venta venta);

    void saveDetallesVenta(DetallesVenta detallesVenta);

    void deleteDetalleVenta(Integer id);
}
