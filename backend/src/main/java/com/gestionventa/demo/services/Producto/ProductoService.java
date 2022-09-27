package com.gestionventa.demo.services.Producto;


import com.gestionventa.demo.models.Producto;
import com.gestionventa.demo.models.ResponseModel;

import java.util.List;

public interface ProductoService {

    List<Producto> productos();
    ResponseModel<Producto> producto(Integer id);
    ResponseModel<?> saveProducto(Producto producto);
    ResponseModel<?> updateProducto(Producto producto,Integer id);
    ResponseModel<?> deleteProducto(Integer id);
}
