package com.gestionventa.demo.controllers;

import com.gestionventa.demo.models.DetallesVenta;
import com.gestionventa.demo.models.Venta;
import com.gestionventa.demo.services.DetallesVentaServiceImp;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class DetallesVentaControllers {
    private final DetallesVentaServiceImp detallesVentaServiceImp;


    public DetallesVentaControllers(DetallesVentaServiceImp detallesVentaServiceImp) {
        this.detallesVentaServiceImp = detallesVentaServiceImp;
    }

    @GetMapping("/detalleventa")
    public List<DetallesVenta> detallesVentaListXVenta(Venta venta){
        return detallesVentaServiceImp.findByIdVentas(venta);
    }

    @PostMapping("/detalleventa")
    public DetallesVenta saveDetalleVenta(DetallesVenta detallesVenta){
        return detallesVentaServiceImp.saveDetallesVenta(detallesVenta);
    }

    @PutMapping("/ActualizarStock")
    public void actualizarStock(List<DetallesVenta> detallesVentas){
        detallesVentaServiceImp.updateProductosYventa(detallesVentas);
    }

    @DeleteMapping("/detalleventa")
    public void deleteDetalleVenta(Integer id){
        detallesVentaServiceImp.deleteDetalleVenta(id);
    }
}
