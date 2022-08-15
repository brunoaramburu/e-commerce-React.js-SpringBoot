package com.gestionventa.demo.services;

import com.gestionventa.demo.models.Producto;
import com.gestionventa.demo.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImp implements ProductoService{

    private final ProductoRepository productoRepository;

    public ProductoServiceImp(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> productos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto poducto(Integer id) {

        if(productoRepository.existsById(id)){
         return productoRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public void updateProducto(Producto producto) {

        if (producto.getId() != null){
            if (productoRepository.existsById(producto.getId())){
                productoRepository.save(producto);
            }
        }
    }

    @Override
    public void deleteProducto(Integer id) {
        productoRepository.deleteById(id);
    }
}
