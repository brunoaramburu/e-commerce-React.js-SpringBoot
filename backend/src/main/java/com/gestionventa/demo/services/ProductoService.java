package com.gestionventa.demo.services;


import com.gestionventa.demo.models.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> productos();
    Producto poducto(Integer id);
    Producto saveProducto(Producto producto);
    void updateProducto(Producto producto);
    void deleteProducto(Integer id);
}
