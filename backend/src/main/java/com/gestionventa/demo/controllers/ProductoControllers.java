package com.gestionventa.demo.controllers;

import com.gestionventa.demo.models.Producto;
import com.gestionventa.demo.services.ProductoServiceImp;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ProductoControllers {

    private final ProductoServiceImp productoServiceImp;


    public ProductoControllers(ProductoServiceImp productoServiceImp) {
        this.productoServiceImp = productoServiceImp;
    }

    @GetMapping("/productos")
    public List<Producto> productos(){
        return productoServiceImp.productos();
    }

    @GetMapping("/productos/{id}")
    public Producto producto(@PathVariable("id") Integer id){
        return productoServiceImp.poducto(id);
    }

    @PostMapping("/productos")
    public Producto saveProducto(@RequestBody Producto producto){
        return productoServiceImp.saveProducto(producto);
    }

    @PutMapping("/productos")
    public void updateProducto(@RequestBody Producto producto){
        productoServiceImp.updateProducto(producto);
    }

    @DeleteMapping("/productos/{id}")
    public void deleteProducto(@PathVariable("id") Integer id){
        productoServiceImp.deleteProducto(id);
    }
}
