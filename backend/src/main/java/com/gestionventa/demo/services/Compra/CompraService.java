package com.gestionventa.demo.services.Compra;


import com.gestionventa.demo.models.Compra;
import com.gestionventa.demo.models.ResponseModel;

import java.util.List;

public interface CompraService {

    List<Compra> compras();

    ResponseModel<Compra> compra(Integer id);

    ResponseModel<?> saveCompra(Compra compra);

    ResponseModel<?> updateCompra(Compra compra);

    ResponseModel<?> deleteCompra(Integer id);
}
