package com.gestionventa.demo.controllers;

import com.gestionventa.demo.models.DetallesCompra;
import com.gestionventa.demo.models.Compra;
import com.gestionventa.demo.services.DetallesCompraServiceImp;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class DetallesCompraControllers {
    private final DetallesCompraServiceImp detallesCompraServiceImp;


    public DetallesCompraControllers(DetallesCompraServiceImp detallesCompraServiceImp) {
        this.detallesCompraServiceImp = detallesCompraServiceImp;
    }

    @GetMapping("/detallecompra")
    public List<DetallesCompra> detallesVentaListXVenta(Compra compra){
        return detallesCompraServiceImp.findByIdCompra(compra);
    }

    @PostMapping("/detallecompra")
    public DetallesCompra saveDetalleVenta(DetallesCompra detallesCompra){
        return detallesCompraServiceImp.saveDetallesCompra(detallesCompra);
    }

    @PutMapping("/ActualizarStock")
    public void actualizarStock(List<DetallesCompra> detallesCompras){
        detallesCompraServiceImp.updateProductosYCompra(detallesCompras);
    }

    @DeleteMapping("/detallecompra")
    public void deleteDetalleVenta(Integer id){
        detallesCompraServiceImp.deleteDetalleCompra(id);
    }
}
