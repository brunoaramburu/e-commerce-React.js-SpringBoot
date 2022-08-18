package com.gestionventa.demo.services;


import com.gestionventa.demo.models.MapVentaYDetalle;
import com.gestionventa.demo.models.Venta;

import java.util.List;
import java.util.Map;

public interface VentaService {

    List<Venta> ventas();

    Venta venta(Integer id);

    Venta saveVenta(Venta venta);

    void updateVenta(Venta venta);

    void deleteVenta(Integer id);


    Map<Integer, MapVentaYDetalle> MapVentaYDetalle();
}
