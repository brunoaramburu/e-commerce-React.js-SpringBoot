package com.gestionventa.demo.services;


import com.gestionventa.demo.models.Compra;

import java.util.List;

public interface CompraService {

    List<Compra> ventas();

    Compra venta(Integer id);

    Compra saveVenta(Compra compra);

    void updateVenta(Compra compra);

    void deleteVenta(Integer id);
}
