package com.gestionventa.demo.services;

import com.gestionventa.demo.models.DetallesCompra;
import com.gestionventa.demo.models.Compra;

import java.util.List;

public interface DetallesCompraService {

    List<DetallesCompra> detallesCompras();

    List<DetallesCompra> findByIdCompra(Compra compra);

    DetallesCompra saveDetallesCompra(DetallesCompra detallesCompra);

    void deleteDetalleCompra(Integer id);

    void updateProductosYCompra(List<DetallesCompra> detalleCompras);
}
