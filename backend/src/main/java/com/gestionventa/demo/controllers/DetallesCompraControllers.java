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
    private final DetallesCompraServiceImp detallesVentaServiceImp;


    public DetallesCompraControllers(DetallesCompraServiceImp detallesVentaServiceImp) {
        this.detallesVentaServiceImp = detallesVentaServiceImp;
    }

    @GetMapping("/detallecompra")
    public List<DetallesCompra> detallesVentaListXVenta(Compra compra){
        return detallesVentaServiceImp.findByIdCompra(compra);
    }

    @PostMapping("/detallecompra")
    public DetallesCompra saveDetalleVenta(DetallesCompra detallesCompra){
        return detallesVentaServiceImp.saveDetallesCompra(detallesCompra);
    }

    @PutMapping("/ActualizarStock")
    public void actualizarStock(List<DetallesCompra> detallesCompras){
        detallesVentaServiceImp.updateProductosYCompra(detallesCompras);
    }

    @DeleteMapping("/detallecompra")
    public void deleteDetalleVenta(Integer id){
        detallesVentaServiceImp.deleteDetalleCompra(id);
    }
}
