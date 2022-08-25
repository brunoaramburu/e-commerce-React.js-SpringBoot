package com.gestionventa.demo.controllers;
import com.gestionventa.demo.models.Venta;
import com.gestionventa.demo.services.VentaServiceImp;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class VentaControllers {
    private final VentaServiceImp ventaServiceImp;

    public VentaControllers(VentaServiceImp ventaServiceImp) {
        this.ventaServiceImp = ventaServiceImp;
    }

    @GetMapping("/venta")
    public List<Venta> ventas(){
        return ventaServiceImp.ventas();
    }
    @GetMapping("/venta/{id}")
    public Venta venta(@PathVariable(value = "id")Integer id){
        return ventaServiceImp.venta(id);
    }
    @PostMapping("/venta")
    public Venta saveVenta(Venta venta){
        return ventaServiceImp.saveVenta(venta);
    }
    @PutMapping("/venta")
    public void updateVenta(Venta venta){
        ventaServiceImp.updateVenta(venta);
    }

    @DeleteMapping("/venta")
    public void deleteVenta(Integer id){
        ventaServiceImp.deleteVenta(id);
    }

}
